package ru.geekbrains.lessons.lesson2;


public class Notebook {

    String title;
    int ddr;
    int price;


    public Notebook(String title, int ddr, int price) {
        this.title = title;
        this.ddr = ddr;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Notebook " +
                "'" + title + '\'' +
                " ddr - " + ddr +
                " price - " + price +
                " $." ;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDdr() {
        return ddr;
    }

    public void setDdr(Integer ddr) {
        this.ddr = ddr;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
