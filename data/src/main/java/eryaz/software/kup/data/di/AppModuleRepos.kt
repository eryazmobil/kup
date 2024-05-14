package eryaz.software.kup.data.di

import eryaz.software.kup.data.repositories.AuthRepo
import eryaz.software.kup.data.repositories.BarcodeRepo
import eryaz.software.kup.data.repositories.CountingRepo
import eryaz.software.kup.data.repositories.OrderRepo
import eryaz.software.kup.data.repositories.PlacementRepo
import eryaz.software.kup.data.repositories.UserRepo
import eryaz.software.kup.data.repositories.WorkActivityRepo
import org.koin.dsl.module

val appModuleRepos = module {

    factory { AuthRepo(get()) }

    factory { UserRepo(get()) }

    factory { WorkActivityRepo(get()) }

    factory { BarcodeRepo(get()) }

    factory { PlacementRepo(get()) }

    factory { OrderRepo(get()) }

    factory { CountingRepo(get()) }

}