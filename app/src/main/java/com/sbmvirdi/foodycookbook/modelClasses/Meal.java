package com.sbmvirdi.foodycookbook.modelClasses;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

@Entity
public class Meal {

    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "idMeal")
    @SerializedName("idMeal")
    public String idMeal;

    @ColumnInfo(name = "strMeal")
    @SerializedName("strMeal")
    public String strMeal;

    @ColumnInfo(name = "strCategory")
    @SerializedName("strCategory")
    public String strCategory;

    @ColumnInfo(name = "strArea")
    @SerializedName("strArea")
    public String strArea;

    @ColumnInfo(name = "strInstructions")
    @SerializedName("strInstructions")
    public String strInstructions;

    @ColumnInfo(name = "strMealThumb")
    @SerializedName("strMealThumb")
    public String strMealThumb;

    @ColumnInfo(name = "strTags")
    @SerializedName("strTags")
    public String strTags;

    @ColumnInfo(name = "strYoutube")
    @SerializedName("strYoutube")
    public String strYoutube;

    @ColumnInfo(name = "strIngredient1")
    @SerializedName("strIngredient1")
    public String strIngredient1;

    @ColumnInfo(name = "strIngredient2")
    @SerializedName("strIngredient2")
    public String strIngredient2;

    @ColumnInfo(name = "strIngredient3")
    @SerializedName("strIngredient3")
    public String strIngredient3;

    @ColumnInfo(name = "strIngredient4")
    @SerializedName("strIngredient4")
    public String strIngredient4;

    @ColumnInfo(name = "strIngredient5")
    @SerializedName("strIngredient5")
    public String strIngredient5;

    @ColumnInfo(name = "strIngredient6")
    @SerializedName("strIngredient6")
    public String strIngredient6;

    @ColumnInfo(name = "strIngredient7")
    @SerializedName("strIngredient7")
    public String strIngredient7;

    @ColumnInfo(name = "strIngredient8")
    @SerializedName("strIngredient8")
    public String strIngredient8;

    @ColumnInfo(name = "strIngredient9")
    @SerializedName("strIngredient9")
    public String strIngredient9;

    @ColumnInfo(name = "strIngredient10")
    @SerializedName("strIngredient10")
    public String strIngredient10;

    @ColumnInfo(name = "strIngredient11")
    @SerializedName("strIngredient11")
    public String strIngredient11;

    @ColumnInfo(name = "strIngredient12")
    @SerializedName("strIngredient12")
    public String strIngredient12;

    @ColumnInfo(name = "strIngredient13")
    @SerializedName("strIngredient13")
    public String strIngredient13;

    @ColumnInfo(name = "strIngredient14")
    @SerializedName("strIngredient14")
    public String strIngredient14;

    @ColumnInfo(name = "strIngredient15")
    @SerializedName("strIngredient15")
    public String strIngredient15;

    @ColumnInfo(name = "strIngredient16")
    @SerializedName("strIngredient16")
    public String strIngredient16;

    @ColumnInfo(name = "strIngredient17")
    @SerializedName("strIngredient17")
    public String strIngredient17;

    @ColumnInfo(name = "strIngredient18")
    @SerializedName("strIngredient18")
    public String strIngredient18;

    @ColumnInfo(name = "strIngredient19")
    @SerializedName("strIngredient19")
    public String strIngredient19;

    @ColumnInfo(name = "strIngredient20")
    @SerializedName("strIngredient20")
    public String strIngredient20;

    @ColumnInfo(name = "strMeasure1")
    @SerializedName("strMeasure1")
    public String strMeasure1;

    @ColumnInfo(name = "strMeasure2")
    @SerializedName("strMeasure2")
    public String strMeasure2;

    @ColumnInfo(name = "strMeasure3")
    @SerializedName("strMeasure3")
    public String strMeasure3;

    @ColumnInfo(name = "strMeasure4")
    @SerializedName("strMeasure4")
    public String strMeasure4;

    @ColumnInfo(name = "strMeasure5")
    @SerializedName("strMeasure5")
    public String strMeasure5;

    @ColumnInfo(name = "strMeasure6")
    @SerializedName("strMeasure6")
    public String strMeasure6;

    @ColumnInfo(name = "strMeasure7")
    @SerializedName("strMeasure7")
    public String strMeasure7;

    @ColumnInfo(name = "strMeasure8")
    @SerializedName("strMeasure8")
    public String strMeasure8;

    @ColumnInfo(name = "strMeasure9")
    @SerializedName("strMeasure9")
    public String strMeasure9;

    @ColumnInfo(name = "strMeasure10")
    @SerializedName("strMeasure10")
    public String strMeasure10;

    @ColumnInfo(name = "strMeasure11")
    @SerializedName("strMeasure11")
    public String strMeasure11;

    @ColumnInfo(name = "strMeasure12")
    @SerializedName("strMeasure12")
    public String strMeasure12;

    @ColumnInfo(name = "strMeasure13")
    @SerializedName("strMeasure13")
    public String strMeasure13;

    @ColumnInfo(name = "strMeasure14")
    @SerializedName("strMeasure14")
    public String strMeasure14;

    @ColumnInfo(name = "strMeasure15")
    @SerializedName("strMeasure15")
    public String strMeasure15;

    @ColumnInfo(name = "strMeasure16")
    @SerializedName("strMeasure16")
    public String strMeasure16;

    @ColumnInfo(name = "strMeasure17")
    @SerializedName("strMeasure17")
    public String strMeasure17;

    @ColumnInfo(name = "strMeasure18")
    @SerializedName("strMeasure18")
    public String strMeasure18;

    @ColumnInfo(name = "strMeasure19")
    @SerializedName("strMeasure19")
    public String strMeasure19;

    @ColumnInfo(name = "strMeasure20")
    @SerializedName("strMeasure20")
    public String strMeasure20;

    @ColumnInfo(name = "strSource")
    @SerializedName("strSource")
    public String strSource;

    public Meal(String idMeal, String strMeal, String strCategory, String strArea, String strInstructions, String strMealThumb, String strTags, String strYoutube, String strIngredient1, String strIngredient2, String strIngredient3, String strIngredient4, String strIngredient5, String strIngredient6, String strIngredient7, String strIngredient8, String strIngredient9, String strIngredient10, String strIngredient11, String strIngredient12, String strIngredient13, String strIngredient14, String strIngredient15, String strIngredient16, String strIngredient17, String strIngredient18, String strIngredient19, String strIngredient20, String strMeasure1, String strMeasure2, String strMeasure3, String strMeasure4, String strMeasure5, String strMeasure6, String strMeasure7, String strMeasure8, String strMeasure9, String strMeasure10, String strMeasure11, String strMeasure12, String strMeasure13, String strMeasure14, String strMeasure15, String strMeasure16, String strMeasure17, String strMeasure18, String strMeasure19, String strMeasure20, String strSource) {
        this.idMeal = idMeal;
        this.strMeal = strMeal;
        this.strCategory = strCategory;
        this.strArea = strArea;
        this.strInstructions = strInstructions;
        this.strMealThumb = strMealThumb;
        this.strTags = strTags;
        this.strYoutube = strYoutube;
        this.strIngredient1 = strIngredient1;
        this.strIngredient2 = strIngredient2;
        this.strIngredient3 = strIngredient3;
        this.strIngredient4 = strIngredient4;
        this.strIngredient5 = strIngredient5;
        this.strIngredient6 = strIngredient6;
        this.strIngredient7 = strIngredient7;
        this.strIngredient8 = strIngredient8;
        this.strIngredient9 = strIngredient9;
        this.strIngredient10 = strIngredient10;
        this.strIngredient11 = strIngredient11;
        this.strIngredient12 = strIngredient12;
        this.strIngredient13 = strIngredient13;
        this.strIngredient14 = strIngredient14;
        this.strIngredient15 = strIngredient15;
        this.strIngredient16 = strIngredient16;
        this.strIngredient17 = strIngredient17;
        this.strIngredient18 = strIngredient18;
        this.strIngredient19 = strIngredient19;
        this.strIngredient20 = strIngredient20;
        this.strMeasure1 = strMeasure1;
        this.strMeasure2 = strMeasure2;
        this.strMeasure3 = strMeasure3;
        this.strMeasure4 = strMeasure4;
        this.strMeasure5 = strMeasure5;
        this.strMeasure6 = strMeasure6;
        this.strMeasure7 = strMeasure7;
        this.strMeasure8 = strMeasure8;
        this.strMeasure9 = strMeasure9;
        this.strMeasure10 = strMeasure10;
        this.strMeasure11 = strMeasure11;
        this.strMeasure12 = strMeasure12;
        this.strMeasure13 = strMeasure13;
        this.strMeasure14 = strMeasure14;
        this.strMeasure15 = strMeasure15;
        this.strMeasure16 = strMeasure16;
        this.strMeasure17 = strMeasure17;
        this.strMeasure18 = strMeasure18;
        this.strMeasure19 = strMeasure19;
        this.strMeasure20 = strMeasure20;
        this.strSource = strSource;
    }

    public Meal() {
    }

    public int getId() {
        return id;
    }

    public String getIdMeal() {
        return idMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public String getStrTags() {
        return strTags;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public String getStrIngredient2() {
        return strIngredient2;
    }

    public String getStrIngredient3() {
        return strIngredient3;
    }

    public String getStrIngredient4() {
        return strIngredient4;
    }

    public String getStrIngredient5() {
        return strIngredient5;
    }

    public String getStrIngredient6() {
        return strIngredient6;
    }

    public String getStrIngredient7() {
        return strIngredient7;
    }

    public String getStrIngredient8() {
        return strIngredient8;
    }

    public String getStrIngredient9() {
        return strIngredient9;
    }

    public String getStrIngredient10() {
        return strIngredient10;
    }

    public String getStrIngredient11() {
        return strIngredient11;
    }

    public String getStrIngredient12() {
        return strIngredient12;
    }

    public String getStrIngredient13() {
        return strIngredient13;
    }

    public String getStrIngredient14() {
        return strIngredient14;
    }

    public String getStrIngredient15() {
        return strIngredient15;
    }

    public String getStrIngredient16() {
        return strIngredient16;
    }

    public String getStrIngredient17() {
        return strIngredient17;
    }

    public String getStrIngredient18() {
        return strIngredient18;
    }

    public String getStrIngredient19() {
        return strIngredient19;
    }

    public String getStrIngredient20() {
        return strIngredient20;
    }

    public String getStrMeasure1() {
        return strMeasure1;
    }

    public String getStrMeasure2() {
        return strMeasure2;
    }

    public String getStrMeasure3() {
        return strMeasure3;
    }

    public String getStrMeasure4() {
        return strMeasure4;
    }

    public String getStrMeasure5() {
        return strMeasure5;
    }

    public String getStrMeasure6() {
        return strMeasure6;
    }

    public String getStrMeasure7() {
        return strMeasure7;
    }

    public String getStrMeasure8() {
        return strMeasure8;
    }

    public String getStrMeasure9() {
        return strMeasure9;
    }

    public String getStrMeasure10() {
        return strMeasure10;
    }

    public String getStrMeasure11() {
        return strMeasure11;
    }

    public String getStrMeasure12() {
        return strMeasure12;
    }

    public String getStrMeasure13() {
        return strMeasure13;
    }

    public String getStrMeasure14() {
        return strMeasure14;
    }

    public String getStrMeasure15() {
        return strMeasure15;
    }

    public String getStrMeasure16() {
        return strMeasure16;
    }

    public String getStrMeasure17() {
        return strMeasure17;
    }

    public String getStrMeasure18() {
        return strMeasure18;
    }

    public String getStrMeasure19() {
        return strMeasure19;
    }

    public String getStrMeasure20() {
        return strMeasure20;
    }

    public String getStrSource() {
        return strSource;
    }
}
