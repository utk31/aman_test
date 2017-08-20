package com.mkyong.rest;

public class Pole
{

    private String uid1;
    private String uid3;
    private String uid4;
    private String construction_status;
    /**
     * @return the uid1
     */
    public String getUid1()
    {
        return uid1;
    }
    /**
     * @param uid1 the uid1 to set
     */
    public void setUid1(String uid1)
    {
        this.uid1 = uid1;
    }
    /**
     * @return the uid3
     */
    public String getUid3()
    {
        return uid3;
    }
    /**
     * @param uid3 the uid3 to set
     */
    public void setUid3(String uid3)
    {
        this.uid3 = uid3;
    }
    /**
     * @return the uid4
     */
    public String getUid4()
    {
        return uid4;
    }
    /**
     * @param uid4 the uid4 to set
     */
    public void setUid4(String uid4)
    {
        this.uid4 = uid4;
    }
    /**
     * @return the construction_status
     */
    public String getConstruction_status()
    {
        return construction_status;
    }
    /**
     * @param construction_status the construction_status to set
     */
    public void setConstruction_status(String construction_status)
    {
        this.construction_status = construction_status;
    }
    /**
     * @param uid1
     * @param uid3
     * @param uid4
     * @param construction_status
     */
    public Pole(String uid1, String uid3, String uid4, String construction_status)
    {
        super();
        this.uid1 = uid1;
        this.uid3 = uid3;
        this.uid4 = uid4;
        this.construction_status = construction_status;
    }
    
}
