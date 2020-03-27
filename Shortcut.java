package varinder.study.learnexcelwithexamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class Shortcut extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private static final String TAG = "Shortcut";

    private AdView mAdView;

    private Context mcontext;


    ArrayList<String> titleArrayList;

    private RecyclerView mRecyclerView;

    ShortcutAdaptor adaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shortcut);


        // AddMob code is just as below metioned
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adViewTwo);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        // AddMob ended



        mcontext = Shortcut.this;

        titleArrayList = new ArrayList<String>();

        titleArrayList.add("Ctrl+A   Select All Contents of a Worksheet");
        titleArrayList.add("Ctrl+B   Bold all cells in the highlighted section.");
        titleArrayList.add("Ctrl+D   Fill the Content of the selected cell on top to bottom. CTRL + D");
        titleArrayList.add("Ctrl+F   Search the current sheet.");
        titleArrayList.add("Ctrl+G   Go to a certain area.");
        titleArrayList.add("Ctrl+H   Find and replace.");
        titleArrayList.add("Ctrl+I   Puts italics on all cells in the highlighted section.");
        titleArrayList.add("Ctrl+K   Inserts a hyperlink.");
        titleArrayList.add("Ctrl+P   Print the current sheet.");
        titleArrayList.add("Ctrl+R   Fill Right.");
        titleArrayList.add("Ctrl+S   Saves the open worksheet.");
        titleArrayList.add("Ctrl+U   Underlines all cells in the highlighted section.");
        titleArrayList.add("Ctrl+V   Pastes everything copied onto the clipboard.");
        titleArrayList.add("Ctrl+W   Closes the current workbook.");
        titleArrayList.add("Ctrl+X   Cuts all cells within the highlighted section.");
        titleArrayList.add("Ctrl+Y   Repeats the last entry.");
        titleArrayList.add("Ctrl+Z   Undo the last action.");
        titleArrayList.add("Ctrl+1   Changes the format of the selected cells.");
        titleArrayList.add("Ctrl+2   Bolds all cells in the highlighted section.");
        titleArrayList.add("Ctrl+3   Puts italics all cells in the highlighted section.");
        titleArrayList.add("Ctrl+4   Underlines all cells in the highlighted section.");
        titleArrayList.add("Ctrl+5   Puts a strikethrough all cells in the highlighted section.");
        titleArrayList.add("Ctrl+6   Shows or hides objects.");
        titleArrayList.add("Ctrl+7   Shows or hides the toolbar.");
        titleArrayList.add("Ctrl+8   Toggles the outline symbols.");
        titleArrayList.add("Ctrl+9   Hides rows.");
        titleArrayList.add("Ctrl+0   Hides columns.");
        titleArrayList.add("Ctrl+Shift+:   Enters the current time.");
        titleArrayList.add("Ctrl+;   Enters the current date.");
        titleArrayList.add("Ctrl+`   Changes between displaying cell values or formulas in the worksheet.");
        titleArrayList.add("Ctrl+’   Copies a formula from the cell above.");
        titleArrayList.add("Ctrl+Shift+”   Copies value from the cell above.");
        titleArrayList.add("Ctrl+-   Deletes the selected column or row.");
        titleArrayList.add("Ctrl+Shift+=   Inserts a new column or row.");
        titleArrayList.add("Ctrl+Shift+~   Switches between showing Excel formulas or their values in cells.");
        titleArrayList.add("Ctrl+Shift+@   Applies time formatting.");
        titleArrayList.add("Ctrl+Shift+!   Applies comma formatting.");
        titleArrayList.add("Ctrl+Shift+$   Applies currency formatting.");
        titleArrayList.add("Ctrl+Shift+#   Applies date formatting.");
        titleArrayList.add("Ctrl+Shift+%   Applies percentage formatting.");
        titleArrayList.add("Ctrl+Shift+^   Applies exponential formatting.");
        titleArrayList.add("Ctrl+Shift+*   Selects the current region around the active cell.");
        titleArrayList.add("Ctrl+Shift+&   Places border around selected cells.");
        titleArrayList.add("Ctrl+Shift+_   Removes a border.");
        titleArrayList.add("Ctrl++   Insert.");
        titleArrayList.add("Ctrl+-   Delete.");
        titleArrayList.add("Ctrl+Shift+(   Unhide rows. ");
        titleArrayList.add("Ctrl+Shift+)   Unhide columns.");
        titleArrayList.add("Ctrl+/   Selects the array containing the active cell.");
        titleArrayList.add("Ctrl+\\   Selects the cells that have a static value or don’t match the formula in the active cell.");
        titleArrayList.add("Ctrl+[   Selects all cells referenced by formulas in the highlighted section.");
        titleArrayList.add("Ctrl+]   Selects cells that contain formulas that reference the active cell.");
        titleArrayList.add("Ctrl+Shift+{   Selects all cells directly or indirectly referenced by formulas in the highlighted section.");
        titleArrayList.add("Ctrl+Shift+}   Selects cells that contain formulas that directly or indirectly reference the active cell.");
        titleArrayList.add("Ctrl+Shift+| (pipe)   Selects the cells within a column that don’t match the formula or static value in the active cell.");
        titleArrayList.add("Ctrl+Enter   Fills the selected cells with the current entry.");
        titleArrayList.add("Ctrl+Spacebar   Selects the entire column.");
        titleArrayList.add("Ctrl+Shift+Spacebar   Selects the entire worksheet.");
        titleArrayList.add("Ctrl+Home   Move to cell A1.");
        titleArrayList.add("Ctrl+End   Move to the last cell on a worksheet.");
        titleArrayList.add("Ctrl+Tab   Move between Two or more open Excel files.");
        titleArrayList.add("Ctrl+Shift+Tab   Activates the previous workbook.");
        titleArrayList.add("Ctrl+Shift+A   Inserts argument names into a formula.");
        titleArrayList.add("Ctrl+Shift+F   Opens the drop-down menu for fonts.");
        titleArrayList.add("Ctrl+Shift+O   Selects all of the cells that contain comments.");
        titleArrayList.add("Ctrl+Shift+P   Opens the drop-down menu for the point size.");
        titleArrayList.add("Shift+Insert   Pastes what is stored on the clipboard.");
        titleArrayList.add("Shift+Page Up   In a single column, highlights all cells above that which are selected.");
        titleArrayList.add("Shift+Page Down   In a single column, highlights all cells above that which are selected.");
        titleArrayList.add("Shift+Home   Highlights all text to the left of the cursor.");
        titleArrayList.add("Shift+End   Highlights all text to the right of the cursor.");
        titleArrayList.add("Shift+Up Arrow   Extends the highlighted area up to one cell.");
        titleArrayList.add("Shift+Down Arrow   Extends the highlighted area down one cell.");
        titleArrayList.add("Shift+Left Arrow   Extends the highlighted area left one character.");
        titleArrayList.add("Shift +Right Arrow   Extends the highlighted area right one character.");
        titleArrayList.add("Alt+Tab   Cycles through applications.");
        titleArrayList.add("Alt+Spacebar   Opens the system menu.");
        titleArrayList.add("Alt+Backpspace   Undo.");
        titleArrayList.add("Alt+Enter   While typing text in a cell, pressing Alt+Enter will move to the next line, allowing for multiple lines of text in one cell.");
        titleArrayList.add("Alt+=   It creates a formula to sum all of the above cells.");
        titleArrayList.add("Alt+’   Allows formatting on a dialog box.");
        titleArrayList.add("F1   Opens the Help menu.");
        titleArrayList.add("F2   Edits the selected cell.");
        titleArrayList.add("F3   After a name has been created, F3 will paste names.");
        titleArrayList.add("F4   Repeats the last action. For example, if you changed the color of the text in another cell, pressing F4 will change the text in a cell to the same color.");
        titleArrayList.add("F5   Goes to a specific cell. For example, C6.");
        titleArrayList.add("F6   Move to the next pane.");
        titleArrayList.add("F7   Spell check selected text or document.");
        titleArrayList.add("F8   Enters Extend Mode.");
        titleArrayList.add("F9   Recalculates every workbook.");
        titleArrayList.add("F10   Activates the menu bar.");
        titleArrayList.add("F11   Creates a chart from selected data.");
        titleArrayList.add("F12   Save as.");
        titleArrayList.add("Shift+F1   Opens the “What’s This?” window.");
        titleArrayList.add("Shift+F2   It allows the user to edit a cell comment.");
        titleArrayList.add("Shift+F3   Opens the Excel formula window");
        titleArrayList.add("Shift+F5   Brings up a search box.");
        titleArrayList.add("Shift+F6   Move to the previous pane.");
        titleArrayList.add("Shift+F8   Add to selection.");
        titleArrayList.add("Shift+F9   Performs calculate function on the active sheet.");
        titleArrayList.add("Ctrl+F3   Open Excel Name Manager.");
        titleArrayList.add("Ctrl+F4   Closes current Window.");
        titleArrayList.add("Ctrl+F5   Restores window size.");
        titleArrayList.add("Ctrl+F6   Next workbook.");
        titleArrayList.add("Ctrl+Shift+F6\t   Previous workbook.");
        titleArrayList.add("Ctrl+F7   Moves the window.");
        titleArrayList.add("Ctrl+F8   Resizes the window.");
        titleArrayList.add("Ctrl+F9   Minimize the current window.");
        titleArrayList.add("Ctrl+F10   Maximize the currently selected window.");
        titleArrayList.add("Ctrl+F11   Inserts a macro sheet.");
        titleArrayList.add("Ctrl+F12   Opens a file.");
        titleArrayList.add("Ctrl+Shift+F3   Creates names by using those of either row or column labels.");
        titleArrayList.add("Ctrl+Shift+F6   Moves to the previous worksheet window.");
        titleArrayList.add("Ctrl+Shift+F12   Prints the current worksheet.");
        titleArrayList.add("Alt+F1   Inserts a chart.");
        titleArrayList.add("Alt+F2   Save as.");
        titleArrayList.add("Alt+F4   Exits Excel.");
        titleArrayList.add("Alt+F8   Opens the macro dialog box.");
        titleArrayList.add("Alt+F11   Opens the Visual Basic editor.");
        titleArrayList.add("Alt+Shift+F1   Creates a new worksheet.");
        titleArrayList.add("Alt+Shift+F2   Saves the current worksheet.");
        titleArrayList.add("Shift + F11   Inserts a new worksheet");
        titleArrayList.add("Ctrl + PgDn   Next Worksheet");
        titleArrayList.add("Ctrl + PgUp   Previous Worksheet");
        titleArrayList.add("Ctrl + Tab   Go to next Workbook");
        titleArrayList.add("F6   It lets you move to next Pane");
        titleArrayList.add("Shift F6   It makes you move to the previous pane");
        titleArrayList.add("Ctrl + Shift + Tab   Previous Workbook");
        titleArrayList.add("Ctrl + F9   Minimize");
        titleArrayList.add("Ctrl + F10   Maximize");
        titleArrayList.add("Shift + Click   Select Adjacent Worksheets");
        titleArrayList.add("Ctrl + Click   Select non-adjacent Worksheets");
        titleArrayList.add("Ctrl + Shift + F1   Full Screen Toggle");
        titleArrayList.add("Tab   Move to next control");
        titleArrayList.add("Shift + Tab   Move to the previous control");
        titleArrayList.add("Ctrl + Tab   Move to next Tab");
        titleArrayList.add("Ctrl + Shift + tab   Move to Previous Tab");
        titleArrayList.add("Ctrl + N   New Workbook");
        titleArrayList.add("Ctrl + O   Open Workbook");
        titleArrayList.add("Ctrl + S   Save Workbook");
        titleArrayList.add("F12   Save As");
        titleArrayList.add("Ctrl + P   Print File");
        titleArrayList.add("Ctrl + F2   Open Print Preview");
        titleArrayList.add("Ctrl + F4   Close Workbook");
        titleArrayList.add("Alt + F4   Close Excel");
        titleArrayList.add("Ctrl + F1   Expand or close Ribbon");
        titleArrayList.add("Alt   Activate Access Keys");
        titleArrayList.add("Tab   Move to next control on Ribbon");
        titleArrayList.add("F1   Help");
        titleArrayList.add("Alt + F + T   Open Options");
        titleArrayList.add("F1   Open Help");
        titleArrayList.add("Ctrl + Z   Undo");
        titleArrayList.add("Ctrl + Y   Redo");
        titleArrayList.add("F4 Repeat Last Actions");
        titleArrayList.add("Ctrl + C   Copy");
        titleArrayList.add("Ctrl + X   Cut");
        titleArrayList.add("Ctrl + V   Paste");
        titleArrayList.add("Ctrl + Alt + V   Display Paste Special Dialogue Box");
        titleArrayList.add("Ctrl + F   Find Box");
        titleArrayList.add("Ctrl + H   Find and Replace");
        titleArrayList.add("Shift + F4   Find next match");
        titleArrayList.add("Ctrl + Shift + F4   Find Previous Match");
        titleArrayList.add("Alt + F1   Create an Embedded Chart");
        titleArrayList.add("F11   Create Chart in new Worksheet");


        mRecyclerView = (RecyclerView)findViewById(R.id.title_layout_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        adaptor = new ShortcutAdaptor(mcontext, titleArrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                // Toast.makeText(mcontext, "clicked"+titleArrayList.get(position), Toast.LENGTH_SHORT).show();

               // Intent desIntent = new Intent(mcontext, DescriptionActivity.class);

               // desIntent.putExtra("tiles", titleArrayList.get(position));

                // startActivity(desIntent);
            }
        });

        mRecyclerView.setAdapter(adaptor);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String userInput = newText.toLowerCase();
        ArrayList<String> newList = new ArrayList<>();

        for (String name : titleArrayList){
            if (name.toLowerCase().contains(userInput)){
                newList.add(name);
            }
        }
        adaptor.updateList(newList);

        return true;
    }
}

design for shortcut file
code is here

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layout_behavior="@string/appbar_scrolling_view_behavior"
    tools:context=".Shortcut"
    >



    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/title_layout_recyclerview"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <com.google.android.gms.ads.AdView
        android:id="@+id/adViewTwo"
        android:layout_width="352dp"
        android:layout_height="65dp"
        android:layout_alignParentBottom="true"
        android:layout_centerInParent="true"
        android:layout_marginBottom="0dp"
        app:adSize="BANNER"
        app:adUnitId="ca-app-pub-1606790808026247/3473961879">

    </com.google.android.gms.ads.AdView>


</RelativeLayout>
