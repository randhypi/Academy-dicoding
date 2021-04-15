package com.randhypi.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.randhypi.academy.data.CourseEntity
import com.randhypi.academy.utils.DataDummy

class BookmarkViewModel: ViewModel() {
    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()
}
