package reflections;

public class SampleClass {
    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

    private String key;
    private Integer value;

    public SampleClass(String key, Integer value) {
        this(key);
        this.value = value;
    }

    public SampleClass(String key) {
        this.key = key;
    }

    private String computeValue() {
        return String.format("Key:%s, Value:%d", this.key, this.value);
    }

    public String getKeyValue() {
        return computeValue();
    }
}
