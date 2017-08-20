package com.mkyong.rest;

public class Layer
{
    private String gid;

    private String colname;

    private String coldata;

    private String coltext;
    
    

    /**
     * @param gid
     * @param colname
     * @param coldata
     * @param coltext
     */
    public Layer(String gid, String colname, String coldata, String coltext)
    {
        super();
        this.gid = gid;
        this.colname = colname;
        this.coldata = coldata;
        this.coltext = coltext;
    }

    /**
     * @return the gid
     */
    public String getGid()
    {
        return gid;
    }

    /**
     * @param gid
     *            the gid to set
     */
    public void setGid(String gid)
    {
        this.gid = gid;
    }

    /**
     * @return the colname
     */
    public String getColname()
    {
        return colname;
    }

    /**
     * @param colname
     *            the colname to set
     */
    public void setColname(String colname)
    {
        this.colname = colname;
    }

    /**
     * @return the coldata
     */
    public String getColdata()
    {
        return coldata;
    }

    /**
     * @param coldata
     *            the coldata to set
     */
    public void setColdata(String coldata)
    {
        this.coldata = coldata;
    }

    /**
     * @return the coltext
     */
    public String getColtext()
    {
        return coltext;
    }

    /**
     * @param coltext
     *            the coltext to set
     */
    public void setColtext(String coltext)
    {
        this.coltext = coltext;
    }

}
