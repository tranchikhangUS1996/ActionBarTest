package com.tranchikhang.actionbartest;

class Pizza {
    private String Name;
    private int ResourceId;
    public static final Pizza[] pizzas = {new Pizza("Diavolo",R.drawable.diavolo),
            new Pizza("Funghi",R.drawable.funghi),
            new Pizza("Alternative",R.drawable.alternative),
            new Pizza("Califonia",R.drawable.california),
            new Pizza("Deepdish",R.drawable.deepdish),
            new Pizza("Flat",R.drawable.flat),
            new Pizza("Greek",R.drawable.greek),
            new Pizza("Margherita",R.drawable.margherita),
            new Pizza("Sicilian",R.drawable.sicilian),
            new Pizza("Tomato",R.drawable.tomato)};
    public Pizza(String name, int resourceId ) {
        this.Name = name;
        this.ResourceId = resourceId;
    }

    public String getName() {
        return this.Name;
    }

    public int getResourceId() {
        return this.ResourceId;
    }

    public String toString() {
        return this.Name;
    }
}
