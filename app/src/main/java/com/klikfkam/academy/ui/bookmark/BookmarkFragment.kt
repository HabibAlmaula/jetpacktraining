package com.klikfkam.academy.ui.bookmark


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.klikfkam.academy.R
import com.klikfkam.academy.data.CourseEntity
import com.klikfkam.academy.utils.DataDummy
import kotlinx.android.synthetic.main.fragment_bookmark.*


class BookmarkFragment : Fragment(), BookmarkFragmentCallback {

    private lateinit var bookmarkAdapter: BookmarkAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bookmark, container, false)
    }

    companion object{
        fun newInstance(): Fragment {
            return BookmarkFragment()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        bookmarkAdapter = context?.let { BookmarkAdapter(it,DataDummy.generateDummyCourses()) }!!
        rv_bookmark.layoutManager = LinearLayoutManager(context)
        rv_bookmark.setHasFixedSize(true)
        rv_bookmark.adapter = bookmarkAdapter

    }

    override fun onShareClick(course: CourseEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(activity!!)
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText(String.format("Segera daftar kelas %s di dicoding.com", course.title))
                .startChooser()
        }
    }


}
