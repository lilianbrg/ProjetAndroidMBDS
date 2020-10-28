package com.example.neighbors.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.neighbors.NavigationListener
import com.example.neighbors.R
import com.example.neighbors.data.NeighborRepository
import com.example.neighbors.models.Neighbor

class AddNeighbourFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_neighbor, container, false)
        clickButtonRegister = view.findViewById(R.id.button_enregistrer_add_neighbor)
        return view
    }

    override fun onViewCreated(view:View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        addImage = view.findViewById(R.id.image_url_add_neighbor)
        addName = view.findViewById(R.id.name_add_neighbor)
        addAddress = view.findViewById(R.id.address_add_neighbor)
        addPhone = view.findViewById(R.id.phone_add_neighbor)
        addWebsite = view.findViewById(R.id.webste_add_neighbor)
        addAboutMe = view.findViewById(R.id.apropos_add_neighbor)

        (activity as? NavigationListener)?.let {
            it.updateTitle(R.string.tool_add_fragment)
        }

        if (addImage.text.toString().length <= 0
            && addName.text.toString().length <= 0
            && addPhone.text.toString().length <= 0
            && addAddress.text.toString().length <= 0
            && addAboutMe.text.toString().length <= 0
            && addWebsite.text.toString().length <= 0)
        {
            clickButtonRegister.setEnabled(false);
        }

        addName.doAfterTextChanged {

            if (addImage.text.toString().length <= 0
                || addName.text.toString().length <= 0
                || addPhone.text.toString().length <= 0
                || addAddress.text.toString().length <= 0
                || addAboutMe.text.toString().length <= 0
                || addWebsite.text.toString().length <= 0){
                clickButtonRegister.setEnabled(false);
            }
            else{
                clickButtonRegister.setEnabled(true);
            }
        }

        addImage.doAfterTextChanged {

            if (addImage.text.toString().length <= 0
                || addName.text.toString().length <= 0
                || addPhone.text.toString().length <= 0
                || addAddress.text.toString().length <= 0
                || addAboutMe.text.toString().length <= 0
                || addWebsite.text.toString().length <= 0){
                clickButtonRegister.setEnabled(false);
            }
            else{
                clickButtonRegister.setEnabled(true);
            }
        }

        addPhone.doAfterTextChanged {

            if (addImage.text.toString().length <= 0
                || addName.text.toString().length <= 0
                || addPhone.text.toString().length <= 0
                || addAddress.text.toString().length <= 0
                || addAboutMe.text.toString().length <= 0
                || addWebsite.text.toString().length <= 0){
                clickButtonRegister.setEnabled(false);
            }
            else{
                clickButtonRegister.setEnabled(true);
            }
        }

        addAddress.doAfterTextChanged {

            if (addImage.text.toString().length <= 0
                || addName.text.toString().length <= 0
                || addPhone.text.toString().length <= 0
                || addAddress.text.toString().length <= 0
                || addAboutMe.text.toString().length <= 0
                || addWebsite.text.toString().length <= 0){
                clickButtonRegister.setEnabled(false);
            }
            else{
                clickButtonRegister.setEnabled(true);
            }
        }

        addAboutMe.doAfterTextChanged {

            if (addImage.text.toString().length <= 0
                || addName.text.toString().length <= 0
                || addPhone.text.toString().length <= 0
                || addAddress.text.toString().length <= 0
                || addAboutMe.text.toString().length <= 0
                || addWebsite.text.toString().length <= 0){
                clickButtonRegister.setEnabled(false);
            }
            else{
                clickButtonRegister.setEnabled(true);
            }
        }

        addWebsite.doAfterTextChanged {

            if (addImage.text.toString().length <= 0
                || addName.text.toString().length <= 0
                || addPhone.text.toString().length <= 0
                || addAddress.text.toString().length <= 0
                || addAboutMe.text.toString().length <= 0
                || addWebsite.text.toString().length <= 0){
                clickButtonRegister.setEnabled(false);
            }
            else{
                clickButtonRegister.setEnabled(true);
            }
        }

        clickButtonRegister.setOnClickListener {

            addImage = view.findViewById(R.id.image_url_add_neighbor)
            addName = view.findViewById(R.id.name_add_neighbor)
            addAddress = view.findViewById(R.id.address_add_neighbor)
            addPhone = view.findViewById(R.id.phone_add_neighbor)
            addWebsite = view.findViewById(R.id.webste_add_neighbor)
            addAboutMe = view.findViewById(R.id.apropos_add_neighbor)

            val neighbor = Neighbor(
                id = NeighborRepository.getInstance().getNeighbours().size + 1.toLong(),
                name = addName.text.toString(),
                avatarUrl = addImage.text.toString(),
                address = addAddress.text.toString(),
                phoneNumber = addPhone.text.toString(),
                aboutMe = addAboutMe.text.toString(),
                favorite = false,
                webSite = addWebsite.text.toString()
            )

            NeighborRepository.getInstance().createNeighbour(neighbor)

            activity?.onBackPressed()
        }
    }

    private lateinit var clickButtonRegister: Button
    private lateinit var addImage: EditText
    private lateinit var addName: EditText
    private lateinit var addAddress: EditText
    private lateinit var addPhone: EditText
    private lateinit var addWebsite: EditText
    private lateinit var addAboutMe: EditText
}