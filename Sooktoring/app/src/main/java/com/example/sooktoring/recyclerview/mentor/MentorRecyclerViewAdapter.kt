package com.example.sooktoring.recyclerview.mentor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sooktoring.databinding.MentorItemBinding

class MentorRecyclerViewAdapter: RecyclerView.Adapter<MentorRecyclerViewAdapter.MyViewHolder>() {

    var mentordatalist = mutableListOf<MentorData>()//리사이클러뷰에서 사용할 데이터 미리 정의 -> 나중에 MainActivity등에서 datalist에 실제 데이터 추가

    inner class MyViewHolder(private val binding: MentorItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(mentorData:MentorData){
            //binding.ivMentorProfile = mentorData.mentorImg
            binding.tvMentorName.text = mentorData.mentorName
            binding.tvMentorJob.text = mentorData.mentorJob
            binding.tvMentorYear.text = "(${mentorData.mentorYear}년)"
            binding.tvMentorUniv.text = "${mentorData.mentorUniv} / ${mentorData.mentorMajor}"
        }
    }


    //만들어진 뷰홀더 없을때 뷰홀더(레이아웃) 생성하는 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=MentorItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = mentordatalist.size

    //recyclerview가 viewholder를 가져와 데이터 연결할때 호출
    //적절한 데이터를 가져와서 그 데이터를 사용하여 뷰홀더의 레이아웃 채움
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mentordatalist[position])
    }
}