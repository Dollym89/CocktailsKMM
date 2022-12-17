//
//  CocktailsNavigation.swift
//  Cocktails
//
//  Created by Amin Ashhab on 17.12.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import SwiftUI

class CocktailsNavigation: Navigation {
    @Published var state = NavigationState()

    func routes(for screen: Any.Type) -> some View {
        switch screen {
        case is IngredientsView.Type: Group {}
        case is CocktailsCabinetView.Type: Group {}
        case is CocktailsView.Type: Group {}
        default: Group {}
        }
    }
}
