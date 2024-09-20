package com.example.apiintergration

data class MobileDataItem(
    val basePrice: Int,
    val brand: String,
    val camera: Camera,
    val colorOptions: List<String>,
    val description: String,
    val display: String,
    val featuredImage: String,
    val id: Int,
    val inStock: Boolean,
    val name: String,
    val productCategory: String,
    val stock: Int,
    val storageOptions: List<String>,
    val thumbnailImage: String
)