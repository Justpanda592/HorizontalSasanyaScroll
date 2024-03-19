package com.example.horizontalsasanyascroll;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] coffee_name = {"Американо", "Эспрессо", "Капучино", "Латте", "Раф", "Латте Клен 2.0", "Флэт Уайт", "Ореховый капучино", "#Кофекофе", "Какао", "Матча латте", "Эспрессо тоник"};
    private	Integer[] coffeeThumbIds = { R.drawable._060, R.drawable._061,
            R.drawable._064, R.drawable._066, R.drawable._544, R.drawable._044
            , R.drawable._068, R.drawable._069, R.drawable._075, R.drawable._087
            , R.drawable._651, R.drawable._656};
    private Integer[] coffeeCosts = { 149, 149, 189, 239, 239, 259, 209, 209, 219, 179, 269, 209 };
    private Integer[] coffee_ml = { 150, 80, 200, 400, 220, 300, 170, 150, 220, 220, 250, 190 };
    private String[] coffee_desc = { "Америка́но — способ приготовления кофе, заключающийся в соединении определённого количества горячей воды и эспрессо. Не стоит путать американо с эспрессо-лунго или Лонг блэк.",
            "Эспре́ссо — метод приготовления кофе путём прохождения горячей воды под давлением через фильтр с молотым кофе.",
            "Капучи́но — кофейный напиток итальянской кухни на основе эспрессо с добавлением в него подогретого вспененного молока.",
            "Ла́тте — кофейный напиток на основе молока, представляющий собой трёхслойную смесь из молочной пены, молока и кофе эспрессо.",
            "Раф-кофе — кофейный напиток, готовится путём добавления нагретых паром сливок с небольшим количеством пены в одиночную порцию эспрессо.",
            "Ла́тте «Клен 2.0» — кофейный напиток на основе молока, представляющий собой трёхслойную смесь из молочной пены, молока и кофе эспрессо.",
            "Флэт уайт — кофейный напиток на основе двойного эспрессо с добавлением молока, созданный в 1980-х годах.",
            "«Ореховый» Капучи́но — это готовая смесь растворимого кофе, шоколада и сливок предназначенная для быстрого приготовления капучино в вендинговых кофейных автоматах и автоматических кофемашинах.",
            "#Кофекофе — наше фирменное кофе.",
            "Какао — напиток, в состав которого обязательно входит размолотое какао, а также молоко и сахар. Напиток обычно безалкогольный.",
            "«Матча» Ла́тте — напиток на основе чая, сочетающий в себе порошок ярко-зеленого чая матча и молоко, чтобы создать молочный напиток как альтернатива кофе.",
            "Эспре́ссо тоник — прохладный освежающий напиток с терпким и пряным привкусом."};
    List<ItemsModel> itemslist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridview = (GridView) findViewById(R.id.gridView1);
        ImageAdapter adapter = new ImageAdapter(itemslist, this);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(gridviewOnItemClickListener);
        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        for(int i=0; i < coffee_name.length; i++){
            ItemsModel itemsModel = new ItemsModel(coffee_name[i], coffeeThumbIds[i]);
            itemslist.add(itemsModel);
        }
        final Button btn_hor1 = findViewById(R.id.btn_hor1);
        final Button btn_hor2 = findViewById(R.id.btn_hor2);
        final Button btn_hor3 = findViewById(R.id.btn_hor3);
        final Button btn_hor4 = findViewById(R.id.btn_hor4);
        final Button btn_hor5 = findViewById(R.id.btn_hor5);
        final Button btn_hor6 = findViewById(R.id.btn_hor6);
        final Button btn_hor7 = findViewById(R.id.btn_hor7);
        btn_hor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_hor1.setBackgroundColor(getResources().getColor(R.color.activeColor));
                btn_hor2.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor3.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor4.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor5.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor6.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor7.setBackgroundColor(getResources().getColor(R.color.btn_not));
                adapter.getFilter().filter("Эспрессо");
            }
        });
        btn_hor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_hor2.setBackgroundColor(getResources().getColor(R.color.activeColor));
                btn_hor1.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor3.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor4.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor5.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor6.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor7.setBackgroundColor(getResources().getColor(R.color.btn_not));
                adapter.getFilter().filter("Капучино");
            }
        });
        btn_hor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_hor3.setBackgroundColor(getResources().getColor(R.color.activeColor));
                btn_hor2.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor1.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor4.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor5.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor6.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor7.setBackgroundColor(getResources().getColor(R.color.btn_not));
                adapter.getFilter().filter("Американо");
            }
        });
        btn_hor4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_hor4.setBackgroundColor(getResources().getColor(R.color.activeColor));
                btn_hor2.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor3.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor1.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor5.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor6.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor7.setBackgroundColor(getResources().getColor(R.color.btn_not));
                adapter.getFilter().filter("Латте");
            }
        });
        btn_hor5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_hor5.setBackgroundColor(getResources().getColor(R.color.activeColor));
                btn_hor2.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor3.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor4.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor1.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor6.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor7.setBackgroundColor(getResources().getColor(R.color.btn_not));
                adapter.getFilter().filter("Какао");
            }
        });
        btn_hor6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_hor6.setBackgroundColor(getResources().getColor(R.color.activeColor));
                btn_hor2.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor3.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor4.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor5.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor7.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor1.setBackgroundColor(getResources().getColor(R.color.btn_not));
                adapter.getFilter().filter("Фраппучино");
            }
        });
        btn_hor7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_hor7.setBackgroundColor(getResources().getColor(R.color.activeColor));
                btn_hor2.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor3.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor4.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor5.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor6.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor1.setBackgroundColor(getResources().getColor(R.color.btn_not));
                adapter.getFilter().filter("Раф");
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
    private GridView.OnItemClickListener gridviewOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            CustomDialog dialog = new CustomDialog(MainActivity.this);
            dialog.show();
            TextView textViewMessage = dialog.findViewById(R.id.text_view_message);
            textViewMessage.setText(textViewMessage.getText() + coffee_name[position]);
            TextView textViewCost = dialog.findViewById(R.id.text_view_cost);
            textViewCost.setText(textViewCost.getText() + coffeeCosts[position].toString() + " р.");
            TextView textViewMl = dialog.findViewById(R.id.text_view_ml);
            textViewMl.setText(textViewMl.getText() + coffee_ml[position].toString() + "мл");
            TextView textViewDesc = dialog.findViewById(R.id.text_view_desc);
            textViewDesc.setText(textViewDesc.getText() + coffee_desc[position]);
            ImageView image = dialog.findViewById(R.id.image);
            image.setImageResource(coffeeThumbIds[position]);
        }
    };
    public class ImageAdapter extends BaseAdapter implements Filterable {
        private Context mContext;
        private List<ItemsModel> itemsModelList;
        private List<ItemsModel> itemsModelListFiltered;
        public ImageAdapter(List<ItemsModel> itemsModelList, Context c) {
            mContext = c;
            this.itemsModelList = itemsModelList;
            this.itemsModelListFiltered = itemsModelList;
        }

        public int getCount() {
            return itemsModelListFiltered.size();
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(mContext, R.layout.custom_grid, null);
                holder.textView = (TextView) convertView.findViewById(R.id.text);
                holder.imageView = (ImageView) convertView.findViewById(R.id.image);
                holder.imageView.getLayoutParams().width = 325;
                holder.imageView.getLayoutParams().height = 325;
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            Bitmap bitmap = BitmapFactory.decodeResource(this.mContext.getResources(), itemsModelListFiltered.get(position).getImage());
            Bitmap circularBitmap = ImageHelper.getRoundedCornerBitmap(bitmap, 400);
            holder.imageView.setImageBitmap(circularBitmap);
            holder.textView.setText(itemsModelListFiltered.get(position).getName());
            return convertView;
        }

        class ViewHolder {
            ImageView imageView;
            TextView textView;
        }
        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected  FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();
                    if(constraint == null || constraint.length() == 0){
                        filterResults.count = itemsModelList.size();
                        filterResults.values = itemsModelList;
                    }else{
                        String searchStr = constraint.toString().toLowerCase();
                        List<ItemsModel> resultData = new ArrayList<>();
                        for(ItemsModel itemsModel:itemsModelList){
                            if(itemsModel.getName().toLowerCase().contains(searchStr)){
                                resultData.add(itemsModel);
                            }
                            filterResults.count = resultData.size();
                            filterResults.values = resultData;
                        }
                    }
                    return filterResults;
                }
                @Override
                protected void publishResults(CharSequence constraint, FilterResults results){
                    itemsModelListFiltered = (List<ItemsModel>) results.values;
                    notifyDataSetChanged();
                }
            };
            return filter;
        }
    }
}