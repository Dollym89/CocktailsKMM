import Multiplatform

extension Module {
    func checkForTuple<T, A>(_ type: T.Type, argument: A.Type) {
        let argumentName = String(describing: argument)
        if argumentName.hasPrefix("(") && argumentName.hasSuffix(")") {
            fatalError("""

                Declaring factory for \(type)
                using tuple argument \(argument)
                is an error.
                You have most likely exceeded maximum number of supported parameters for convenience factory methods.
                Try using factory(of:definition:) instead.

            """)
        }
    }
}
