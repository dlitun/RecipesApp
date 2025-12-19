package com.example.recipesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.recipesapp.databinding.FragmentListCategoriesBinding

class CategoriesListFragment : Fragment() {

    private var _binding: FragmentListCategoriesBinding? = null
    private val binding get() = _binding ?: error("FragmentListCategoriesBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        val categories = STUB.getCategories()
        val categoriesAdapter = CategoriesListAdapter(categories)

        categoriesAdapter.setOnItemClickListener(object : CategoriesListAdapter.OnItemClickListener {
            override fun onItemClick(category: Category) {
                openRecipesByCategoryId(category.id)
            }
        })

        binding.rvCategories.adapter = categoriesAdapter
    }

    private fun openRecipesByCategoryId(categoryId: Int) {

        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.mainContainer, RecipesListFragment())
            addToBackStack(null)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}