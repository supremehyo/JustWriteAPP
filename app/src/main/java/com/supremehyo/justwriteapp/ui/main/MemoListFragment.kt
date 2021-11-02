package com.supremehyo.justwriteapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.supremehyo.justwriteapp.R
import com.supremehyo.justwriteapp.adapter.MemoListAdapter
import com.supremehyo.justwriteapp.database.Memo
import com.supremehyo.justwriteapp.database.MemoDatabase
import kotlinx.android.synthetic.main.fragment_memo_list.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//https://github.com/hakobast/DropdownTextView  접고 여는 라이브러리
//https://github.com/sangcomz/StickyTimeLine
//타임라인 라이브러리 사용해서 체크하기
class MemoListFragment : Fragment() {
    private lateinit var db: MemoDatabase
    lateinit var memoListAdapter: MemoListAdapter
    lateinit var list : List<Memo>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_memo_list, container, false)

        db = MemoDatabase.getInstance(view.context)!!

        CoroutineScope(Dispatchers.IO).launch { // 코루틴으로 백그라운드에서 작업하도록
            list = db!!.MemoDAO().getAll()
            memoListAdapter =  MemoListAdapter(list as Array<Memo>)
            memoListAdapter.setHasStableIds(true)
            val LayoutManager = LinearLayoutManager(requireContext())
            val decoration = DividerItemDecoration(context, LinearLayout.VERTICAL)
            memo_list_recyclerView.layoutManager= LayoutManager
            memo_list_recyclerView.addItemDecoration(decoration)
        }

        //리사이클러뷰 스크롤해서 새로 그릴때마다 그 포지션의 데이터 날짜가 언제인지 읽고 대충 그 스크롤따라 포지션 계산
        //가능하면 그걸로 하고 젤 마지막에 스크롤중인 그거의 기록 날짜를 리니어에 바뀌면서 그려지게 ㄱㄱ 날짜 바뀔때 애니메이션 https://it77.tistory.com/223
        //https://thkim-study.tistory.com/14 이 링크 참고

        




        return  view
    }


}