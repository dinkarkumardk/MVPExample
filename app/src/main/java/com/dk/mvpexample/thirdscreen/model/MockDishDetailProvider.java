package com.dk.mvpexample.thirdscreen.model;

/**
 * Created by dinkark on 26/05/18.
 */

public class MockDishDetailProvider {
    public static DishDetail getSampleDishDetail() {
        DishDetail dishDetail = new DishDetail();
        dishDetail.setAddress("32 Spring Street, New York 10012");
        dishDetail.setRating("4.5");
        dishDetail.setName("Lombardi's Pizza");
        dishDetail.setTagline("The paradise of spice blends");
        dishDetail.setPic("https://b.zmtcdn.com/data/res_imagery/16771079_RESTAURANT_da60c9abb32fa64cddc148a2795ae43c_c.jpg");
        return dishDetail;
    }
}
