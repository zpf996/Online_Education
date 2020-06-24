package bean;

import java.math.BigDecimal;

public class Courses {
    private String id;
    private String name;
    private String category;
    private String table_of_content;
    private BigDecimal fees;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTable_of_content() {
        return table_of_content;
    }

    public void setTable_of_content(String table_of_content) {
        this.table_of_content = table_of_content;
    }

    public BigDecimal getFees() {
        return fees;
    }

    public void setFees(BigDecimal fees) {
        this.fees = fees;
    }
}
