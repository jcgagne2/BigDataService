package ch.bdt.spike.spring.cloud.bigdataservice.api;

//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Category {
    Book(false),
    Electronic(true),
    Fashion(true),
    Food(false),
    Garden(true),
    Music(false),
    Sport(false),
    Toys(true);

    private final boolean isMadeInChina;

    private Category(boolean aIsMadeInChina) {
        this.isMadeInChina = aIsMadeInChina;
    }

    public boolean isMadeInChina() {
        return isMadeInChina;
    }

}
