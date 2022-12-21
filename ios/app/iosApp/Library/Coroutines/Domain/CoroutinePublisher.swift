import Multiplatform
import CombineExt
import Combine

public extension Ktx {
    static func publisher<T>(for flow: SwiftFlow<T>) -> AnyPublisher<T, Never> {
        publisherWithError(for: flow)
            .catch { error -> Empty<T, Never> in
                fatalError("SwiftFlow threw KotlinThrowable Error! \n\(error)\n")
            }
            .eraseToAnyPublisher()
    }

    static func publisher<T>(for suspended: SwiftSuspended<T>) -> AnyPublisher<T, Never> {
        publisherWithError(for: suspended)
            .catch { error -> Empty<T, Never> in
                fatalError("SwiftSuspend threw KotlinThrowable Error! \n\(error)\n")
            }
            .eraseToAnyPublisher()
    }

    static func publisherWithError<T>(for flow: SwiftFlow<T>) -> AnyPublisher<T, Error> {
        AnyPublisher.create { subscriber in
            var didComplete = false
            let task = flow.run(
                handleValue: {
                    subscriber.send($0!)
                },
                handleCompletion: {
                    guard !didComplete else { return }
                    didComplete = true
                    subscriber.send(completion: $0 == nil ? .finished : .failure($0!))
                }
            )
            return AnyCancellable(task.cancel)
        }
    }

    static func publisherWithError<T>(for suspended: SwiftSuspended<T>) -> AnyPublisher<T, Error> {
        AnyPublisher.create { subscriber in
            let task = suspended.run(
                handleValue: {
                    subscriber.send($0!)
                    subscriber.send(completion: .finished)
                },
                handleError: {
                    subscriber.send(completion: .failure($0))
                }
            )
            return AnyCancellable(task.cancel)
        }
    }
}

public func publisher<T>(for flow: SwiftFlow<T>) -> AnyPublisher<T, Never> {
    Ktx.publisher(for: flow)
}

public func publisher<T>(for suspended: SwiftSuspended<T>) -> AnyPublisher<T, Never> {
    Ktx.publisher(for: suspended)
}

extension KotlinThrowable: Error {}
