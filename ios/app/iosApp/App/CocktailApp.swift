import SwiftUI
import Multiplatform

@main
struct CocktailApp: App {
    init() {
        SharedApplication().doInit { $0.registerIosModules() }
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
