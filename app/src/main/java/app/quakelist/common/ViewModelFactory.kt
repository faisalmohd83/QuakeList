package app.quakelist.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.quakelist.earthquakes.QuakesViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuakesViewModel::class.java)) {
            return QuakesViewModel() as T
        } /*else if (modelClass.isAssignableFrom(QuakeDetailViewModel::class.java)) {
            return QuakeDetailViewModel() as T
        }*/

        throw IllegalArgumentException("Unknown class name")
    }
}
