class ComboItem
{
    private String key;
    private Spiel value;

    public ComboItem(String key, Spiel value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key;
    }

    public String getKey()
    {
        return key;
    }

    public Spiel getValue()
    {
        return value;
    }
}