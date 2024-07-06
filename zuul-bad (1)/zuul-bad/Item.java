public class Item {
    private String name;
    private String description;//物品描述



    private int kg;
    //无参构造方法。
    public Item(){}
    public Item(String name,String description,int kg)//initialize name and description
    {
        this.name = name;
        this.description = description;
        this.kg = kg;
    }
    //返回物品的名称。
    public String getName(){return name;}//return item name
    //返回物品的描述信息。
    public String getDescription(){return description;}//return item description
    public int getKg() {
        return kg;
    }
    public void setKg(int kg) {
        this.kg = kg;
    }

}

