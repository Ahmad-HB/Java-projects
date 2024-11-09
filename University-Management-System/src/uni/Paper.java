package uni;
public class Paper {
    private String paperID;
    private String paperName;

    public Paper(String paperID, String paperName) {
        this.paperID = paperID;
        this.paperName = paperName;
    }

    public String getPaperID() {
        return paperID;
    }

    public String getPaperName() {
        return paperName;
    }
}
