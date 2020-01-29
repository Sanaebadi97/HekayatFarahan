package info.sanaebadi.hekayatfarahan.di

import info.sanaebadi.hekayatfarahan.repository.Repository
import info.sanaebadi.hekayatfarahan.viewModel.GameDetailsViewModel
import info.sanaebadi.hekayatfarahan.viewModel.GameViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

//koin module
val myModule = module {

    viewModel { GameViewModel() }
    viewModel { GameDetailsViewModel() }
//    viewModel { ViewModel(get()) }
//    single { GameRepository(get()) }
    single { Repository }
}