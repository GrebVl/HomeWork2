package PlushToy;

public abstract class PlushToy {
    private int idToy;
    protected String nameToy;
    private String colorToy;
    private int weight;
    private int amount;

    public PlushToy(String name, String color, int weight, int amount) {
        this.nameToy = name;
        this.colorToy = color;
        this.weight = weight;
        this.amount = amount;
        this.idToy++;
    }

    public int getIdToy() {
        return this.idToy;
    }

    public void setIdToy(int idToy) {
        this.idToy = idToy;
    }

    public String getNameToy() {
        return this.nameToy;
    }

    public void setNameToy(String nameToy) {
        this.nameToy = nameToy;
    }

    public String getColorToy() {
        return this.colorToy;
    }

    public void setColorToy(String color) {
        this.colorToy = color;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Tous{" +
                "name='" + this.nameToy + '\'' +
                ", color=" + this.colorToy +
                ", weught=" + this.weight +
                ", amount=" + this.amount +
                ", id=" + this.idToy +
                '}';
    }

    public void getInfo() {
        System.out.println("######################");
        System.out.printf("Name: %s\nColor: %s\nWeight: %d\nAmount: %d\n",
                this.nameToy, this.colorToy, this.weight, this.amount);
        System.out.println("_________________");
    }
    public void getInfoPrize() {
        System.out.println("!!!!!!!!!!!!!!!!!!!");
        System.out.printf("Name: %s\nColor: %s\n",
                this.nameToy, this.colorToy);
        System.out.println("!!!!!!!!!!!!!!!!!!!");
    }
}
