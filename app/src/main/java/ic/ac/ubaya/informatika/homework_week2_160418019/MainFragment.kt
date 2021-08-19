package ic.ac.ubaya.informatika.homework_week2_160418019

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.random.Random


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
    var num1 = 0
    var num2 = 0
    var ans = 0
    var score = 0

    private fun initialize(){
        num1 = Random.nextInt(0,20)
        num2 = Random.nextInt(0,20)
        ans = num1+num2
        txtNum1.text = num1.toString()
        txtNum2.text = num2.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        btnSubmit.setOnClickListener {
            if(txtAns.text.toString() != ans.toString()){
                val action = MainFragmentDirections.actionMainFragmentToResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
            else{
                score++
                initialize()
                Toast.makeText(activity,"Correct", Toast.LENGTH_SHORT)
            }
        }
    }

}