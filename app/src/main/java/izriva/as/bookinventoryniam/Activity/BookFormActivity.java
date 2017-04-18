package izriva.as.bookinventoryniam.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import izriva.as.bookinventoryniam.R;

public class BookFormActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.editBookTitle)
    EditText editBookTitle;
    @BindView(R.id.editBookAuthor)
    EditText editBookAuthor;
    @BindView(R.id.spinnerGenre)
    Spinner spinnerGenre;
    @BindView(R.id.editIsbn)
    EditText editISBN;
    @BindView(R.id.editPublishedYear)
    EditText editPublishYear;
    @BindView(R.id.editSynopsis)
    EditText editSynopsis;
    @BindView(R.id.btnSave)
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (validate()) {
                    Toast.makeText(BookFormActivity.this, "Data Valid!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private boolean validate() {
        boolean valid = true;

        String isbn = editISBN.getText().toString();
        String booktitle = editBookTitle.getText().toString();
        String bookauthor = editBookAuthor.getText().toString();
        String publishedYear = editPublishYear.getText().toString();

        if (isbn.isEmpty()) {
            editISBN.setError("Enter ISBN");
            valid = false;
        } else {
            editISBN.setError(null);
        }

        if (booktitle.isEmpty()) {
            editBookTitle.setError("Enter Book Title");
            valid = false;
        } else {
            editBookTitle.setError(null);
        }

        if (bookauthor.isEmpty()) {
            editBookAuthor.setError("Enter Book Author");
            valid = false;
        } else {
            editBookAuthor.setError(null);
        }

        if (publishedYear.isEmpty() || publishedYear.length() < 4) {
            editPublishYear.setError("Publish Year empty or must in yyyy format");
            valid = false;
        } else {
            editPublishYear.setError(null);
        }

        return valid;
    }

}
