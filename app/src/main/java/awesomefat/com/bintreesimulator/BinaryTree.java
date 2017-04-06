package awesomefat.com.bintreesimulator;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by michaellitman on 4/6/17.
 */

public class BinaryTree
{
    public boolean isSet;
    private int payload;
    private ViewGroup theTreeView;
    private Context context;
    private BinaryTree leftTree;
    private BinaryTree rightTree;

    public BinaryTree(ViewGroup theTreeView, Context context)
    {
        this.theTreeView = theTreeView;
        this.isSet = false;
        this.leftTree = null;
        this.rightTree = null;
    }

    public BinaryTree(int payload, ViewGroup theTreeView, Context context)
    {
        this(theTreeView, context);
        this.payload = payload;
        this.isSet = true;
    }

    private void addTextViewToTree(int payload)
    {
        TextView tv = new TextView(this.context);
        tv.setText("" + payload);
        this.theTreeView.addView(tv);
    }

    public boolean add(int payload)
    {
        if(!this.isSet)
        {
            this.payload = payload;
            this.addTextViewToTree(payload);
            this.isSet = true;
            return true;
        }
        else
        {
            if(payload <= this.payload)
            {
                //add this payload to the left
                if(this.leftTree == null)
                {
                    this.leftTree = new BinaryTree(payload, theTreeView, this.context);
                    this.addTextViewToTree(payload);
                    return true;
                }
                else
                {
                    //I have a left tree, and I'm going to ask him to
                    //add the payload to himself.
                    return this.leftTree.add(payload);
                }
            }
            else
            {
                //add this payload to the right
                if(this.rightTree == null)
                {
                    this.rightTree = new BinaryTree(payload, this.theTreeView, this.context);
                    this.addTextViewToTree(payload);
                    return true;
                }
                else
                {
                    //I have a right tree, and I'm going to ask him to
                    //add the payload to himself.
                    return this.rightTree.add(payload);
                }
            }
        }
    }

    public void display()
    {
        if(this.isSet)
        {
            System.out.println(this.payload);
            if(this.leftTree != null)
            {
                this.leftTree.display();
            }
            if(this.rightTree != null)
            {
                this.rightTree.display();
            }
        }
        else
        {
            System.out.println("Empty Tree");
        }
    }
}
