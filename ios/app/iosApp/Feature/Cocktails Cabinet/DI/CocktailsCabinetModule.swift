//
//  CocktailsCabinetModule.swift
//  Cocktails
//
//  Created by Amin Ashhab on 17.12.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation

let cocktailsCabinetModule = module {
    $0.factory(using: CocktailsCabinetView.init)
}
