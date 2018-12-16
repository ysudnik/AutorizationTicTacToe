package objects;

import java.util.ArrayList;

public class AllObjects<T>
{

    private ArrayList<T> allObjects;

    public ArrayList<T> getAllObjects()
    {
        return allObjects;
    }

    public void setAllObjects(ArrayList<T> allObjects)
    {
        this.allObjects = allObjects;
    }

    public AllObjects(ArrayList<T> allObjects)
    {
        this.allObjects = allObjects;
    }

    public AllObjects()
    {
    }
}