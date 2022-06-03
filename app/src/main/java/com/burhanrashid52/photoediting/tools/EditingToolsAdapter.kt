package com.burhanrashid52.photoediting.tools

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.burhanrashid52.ReadJSON
import com.burhanrashid52.photoediting.R
import java.util.ArrayList

/**
 * @author [Burhanuddin Rashid](https://github.com/burhanrashid52)
 * @version 0.1.2
 * @since 5/23/2018
 */
class EditingToolsAdapter(private val mOnItemSelected: OnItemSelected, val context: Context) :
    RecyclerView.Adapter<EditingToolsAdapter.ViewHolder>() {
    private val mToolList: MutableList<ToolModel> = ArrayList()

    var readJSON = ReadJSON()

    interface OnItemSelected {
        fun onToolSelected(toolType: ToolType?)
    }

    internal inner class ToolModel(
        val mToolName: String,
        val mToolIcon: Int,
        val mToolType: ToolType
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_editing_tools, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mToolList[position]
        holder.txtTool.text = item.mToolName
        holder.imgToolIcon.setImageResource(item.mToolIcon)
    }

    override fun getItemCount(): Int {
        return mToolList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgToolIcon: ImageView = itemView.findViewById(R.id.imgToolIcon)
        val txtTool: TextView = itemView.findViewById(R.id.txtTool)

        init {
            itemView.setOnClickListener { _: View? ->
                mOnItemSelected.onToolSelected(
                    mToolList[layoutPosition].mToolType
                )
            }
        }
    }

    init {
        mToolList.add(ToolModel(readJSON.getNames(context)[0].toString(), R.drawable.ic_oval, ToolType.SHAPE))
        mToolList.add(ToolModel(readJSON.getNames(context)[1].toString(), R.drawable.ic_text, ToolType.TEXT))
        mToolList.add(ToolModel(readJSON.getNames(context)[2].toString(), R.drawable.ic_eraser, ToolType.ERASER))
        mToolList.add(ToolModel(readJSON.getNames(context)[3].toString(), R.drawable.ic_photo_filter, ToolType.FILTER))
        mToolList.add(ToolModel(readJSON.getNames(context)[4].toString(), R.drawable.ic_insert_emoticon, ToolType.EMOJI))
        mToolList.add(ToolModel(readJSON.getNames(context)[5].toString(), R.drawable.ic_sticker, ToolType.STICKER))
    }
}