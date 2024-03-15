package tudelft.wis.idm_tasks;

public class Title {
    private int title_id ;
    private String title_type ;
    private String primary_title ;
    private String original_title ;
    private int start_year ;
    private int end_year ;
    private int runtime ;
    public Title(int title_id, String primary_title, int start_year){
        this.title_id = title_id ;
        this.primary_title = primary_title ;
        this.start_year = start_year ;
    }
    public int getTitleYear(){
        return start_year ;
    }
    public String getPrimaryTitle(){
        return primary_title ;
    }
}
