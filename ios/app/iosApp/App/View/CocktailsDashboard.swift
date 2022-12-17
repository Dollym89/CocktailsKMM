import SwiftUI

struct CocktailsDashboard: View {
    let navigation: CocktailsNavigation

	var body: some View {
        TabView {
            createTab(
                name: "Cocktails",
                image: Image(systemName: "trash"),
                screen: navigation.screen(for: CocktailsView.self)
            )
            createTab(
                name: "Ingredients",
                image: Image(systemName: "trash"),
                screen: navigation.screen(for: IngredientsView.self)
            )
            createTab(
                name: "Cocktails Cabinet",
                image: Image(systemName: "trash"),
                screen: navigation.screen(for: CocktailsCabinetView.self)
            )
        }
	}
}

// MARK: - ViewBuilder

extension CocktailsDashboard {
    @ViewBuilder func createTab<Content: View>(
        name: String,
        image: Image,
        screen: Content
    ) -> some View {
        NavigationView {
            screen
        }
        .tabItem {
            image
            Text(name)
        }
    }
}
