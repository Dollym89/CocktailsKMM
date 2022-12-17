import SwiftUI
import Multiplatform

@main
struct CocktailApp: App, KoinComponent {
    init() {
        SharedApplication().doInit { $0.registerIosModules() }
    }

	var body: some Scene {
		WindowGroup {
            get(CocktailsDashboard.self)
		}
	}
}
