//
//  AppModule.swift
//  iosApp
//
//  Created by Amin Ashhab on 06.12.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Multiplatform

let appModule = module {
    $0.factory(using: CocktailsDashboard.init)
    $0.single(using: CocktailsNavigation.init)
}
