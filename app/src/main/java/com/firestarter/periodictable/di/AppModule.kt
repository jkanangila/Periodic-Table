package com.firestarter.periodictable.di

import android.app.Application
import com.firestarter.periodictable.data.data_source.PeriodicTableDataBase
import com.firestarter.periodictable.data.repository.ChemicalElementRepositoryImpl
import com.firestarter.periodictable.domain.repository.ChemicalElementsRepository
import com.firestarter.periodictable.domain.use_case.ElectronConfigurationShell
import com.firestarter.periodictable.domain.use_case.GetChemicalElement
import com.firestarter.periodictable.domain.use_case.GetChemicalElementDetails
import com.firestarter.periodictable.domain.use_case.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePeriodicTableDataBase(app: Application): PeriodicTableDataBase {
        return PeriodicTableDataBase.getInstance(app)
    }

    @Provides
    @Singleton
    fun provideChemicalElementRepository(db: PeriodicTableDataBase): ChemicalElementsRepository{
        return ChemicalElementRepositoryImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideElectronConfigurationUseCase(): ElectronConfigurationShell {
        return ElectronConfigurationShell()
    }

    @Provides
    @Singleton
    fun provideUsesCases(repository: ChemicalElementsRepository, usesCase: ElectronConfigurationShell): UseCases{
        return UseCases(
            getChemicalElement = GetChemicalElement(repository),
            getChemicalElementDetails = GetChemicalElementDetails(repository, usesCase)
        )
    }
}