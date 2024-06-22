package com.example.horizontalsasanyascroll;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.List;
import android.util.Log;
import android.widget.Toast;
import android.graphics.PorterDuff;
import androidx.core.content.ContextCompat;

public class HomeActivity extends Fragment {
    private static final String TAG = "MainActivity";
    private String[] coffee_name = {"Американо", "Эспрессо", "Капучино", "Латте", "Раф", "Латте Клен 2.0", "Флэт Уайт", "Ореховый капучино", "#Кофекофе", "Какао", "Матча латте", "Эспрессо тоник"};
    private	Integer[] coffeeThumbIds = { R.drawable._060, R.drawable._061,
            R.drawable._064, R.drawable._066, R.drawable._544, R.drawable._044
            , R.drawable._068, R.drawable._069, R.drawable._075, R.drawable._087
            , R.drawable._651, R.drawable._656};
    private	String[] coffeeThumbNames = { "drawable/_060", "drawable/_061",
            "drawable/_064", "drawable/_066", "drawable/_544", "drawable/_044"
            , "drawable/_068", "drawable/_069", "drawable/_075", "drawable/_087"
            , "drawable/_651", "drawable/_656"};
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
    private Button btn_hor1;
    private Button btn_hor2;
    private Button btn_hor3;
    private Button btn_hor4;
    private Button btn_hor5;
    private Button btn_hor6;
    private Button btn_hor7;
    boolean btn_hor1_act = false;
    boolean btn_hor2_act = false;
    boolean btn_hor3_act = false;
    boolean btn_hor4_act = false;
    boolean btn_hor5_act = false;
    boolean btn_hor6_act = false;
    boolean btn_hor7_act = false;
    List<ItemsModel> itemslist = new ArrayList<>();
    private DBHelper dbHelper;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_home, container, false);
        GridView gridview = (GridView) view.findViewById(R.id.gridView1);
        SearchView searchView = (SearchView) view.findViewById(R.id.searchView);
        for (int i = 0; i < coffee_name.length; i++) {
            ItemsModel itemsModel = new ItemsModel(coffee_name[i], coffeeCosts[i].toString(), coffeeThumbIds[i], coffeeThumbNames[i], coffee_ml[i].toString(), coffee_desc[i]);
            itemslist.add(itemsModel);
        }
        ImageAdapter adapter = new ImageAdapter(itemslist, getContext());
        gridview.setAdapter(adapter);

        btn_hor1 = view.findViewById(R.id.btn_hor1);
        btn_hor2 = view.findViewById(R.id.btn_hor2);
        btn_hor3 = view.findViewById(R.id.btn_hor3);
        btn_hor4 = view.findViewById(R.id.btn_hor4);
        btn_hor5 = view.findViewById(R.id.btn_hor5);
        btn_hor6 = view.findViewById(R.id.btn_hor6);
        btn_hor7 = view.findViewById(R.id.btn_hor7);

        dbHelper = new DBHelper(getContext());

        setupButtonFilter(btn_hor1, adapter, "Эспрессо", 1);
        setupButtonFilter(btn_hor2, adapter, "Капучино", 2);
        setupButtonFilter(btn_hor3, adapter, "Американо", 3);
        setupButtonFilter(btn_hor4, adapter, "Латте", 4);
        setupButtonFilter(btn_hor5, adapter, "Какао", 5);
        setupButtonFilter(btn_hor6, adapter, "Фраппучино", 6);
        setupButtonFilter(btn_hor7, adapter, "Раф", 7);

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
        return view;
    }

    private void setupButtonFilter(Button button, ImageAdapter adapter, String filter, int buttonIndex) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean[] buttonStates = {btn_hor1_act, btn_hor2_act, btn_hor3_act, btn_hor4_act, btn_hor5_act, btn_hor6_act, btn_hor7_act};
                buttonStates[buttonIndex - 1] = !buttonStates[buttonIndex - 1];
                updateButtonStates(buttonStates, adapter, filter, buttonIndex);
            }
        });
    }

    private void updateButtonStates(boolean[] buttonStates, ImageAdapter adapter, String filter, int buttonIndex) {
        Button[] buttons = {btn_hor1, btn_hor2, btn_hor3, btn_hor4, btn_hor5, btn_hor6, btn_hor7};
        for (int i = 0; i < buttons.length; i++) {
            if (i == buttonIndex - 1) {
                if (buttonStates[i]) {
                    buttons[i].setBackgroundColor(getResources().getColor(R.color.activeColor));
                    adapter.getFilter().filter(filter);
                } else {
                    buttons[i].setBackgroundColor(getResources().getColor(R.color.btn_not));
                    adapter.getFilter().filter("");
                }
            } else {
                buttons[i].setBackgroundColor(getResources().getColor(R.color.btn_not));
                buttonStates[i] = false;
            }
        }
        btn_hor1_act = buttonStates[0];
        btn_hor2_act = buttonStates[1];
        btn_hor3_act = buttonStates[2];
        btn_hor4_act = buttonStates[3];
        btn_hor5_act = buttonStates[4];
        btn_hor6_act = buttonStates[5];
        btn_hor7_act = buttonStates[6];
    }

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
                holder.txt_name = (TextView) convertView.findViewById(R.id.txt_name);
                holder.txt_cost = (TextView) convertView.findViewById(R.id.txt_cost);
                holder.imageView = (ImageView) convertView.findViewById(R.id.image);
                holder.imageView.getLayoutParams().width = 325;
                holder.imageView.getLayoutParams().height = 325;
                holder.btn_buy = (Button) convertView.findViewById(R.id.btn_buy);
                holder.btn_favorite = (ImageButton) convertView.findViewById(R.id.btn_favorite);
                holder.btn_favorite.setColorFilter(ContextCompat.getColor(getContext(), R.color.white), PorterDuff.Mode.SRC_IN);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            ItemsModel item = itemsModelListFiltered.get(position);
            holder.txt_name.setText(item.getName());
            holder.txt_cost.setText(item.getCost() + " р.");
            Bitmap bitmap = BitmapFactory.decodeResource(this.mContext.getResources(), item.getImage());
            Bitmap circularBitmap = ImageHelper.getRoundedCornerBitmap(bitmap, 400);
            holder.imageView.setImageBitmap(circularBitmap);

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fragmentManager = getParentFragmentManager();
                    CustomDialog customDialog = new CustomDialog(mContext);
                    customDialog.show();
                    TextView textViewMessage = customDialog.findViewById(R.id.text_view_message);
                    textViewMessage.setText(item.getName());
                    TextView textViewCost = customDialog.findViewById(R.id.text_view_cost);
                    textViewCost.setText(item.getCost() + " р.");
                    TextView textViewMl = customDialog.findViewById(R.id.text_view_ml);
                    textViewMl.setText(item.getMl()  + "мл");
                    TextView textViewDesc = customDialog.findViewById(R.id.text_view_desc);
                    textViewDesc.setText(item.getDesc());
                    ImageView image = customDialog.findViewById(R.id.image);
                    image.setImageResource(item.getImage());
                }
            });

            holder.btn_buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dbHelper.addItemToCart(item.getName(), Integer.parseInt(item.getCost()), item.getImageString(), Integer.parseInt(item.getMl()), item.getDesc());
                }
            });

            holder.btn_favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dbHelper.addItemToFavorite(item.getName(), Integer.parseInt(item.getCost()), item.getImageString(), Integer.parseInt(item.getMl()), item.getDesc());
                }
            });

            return convertView;
        }

        class ViewHolder {
            ImageView imageView;
            TextView txt_name;
            TextView txt_cost;
            Button btn_buy;
            ImageButton btn_favorite;
        }

        @Override
        public Filter getFilter() {
            return new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();
                    if (constraint == null || constraint.length() == 0) {
                        filterResults.count = itemsModelList.size();
                        filterResults.values = itemsModelList;
                    } else {
                        String searchStr = constraint.toString().toLowerCase();
                        List<ItemsModel> resultData = new ArrayList<>();
                        for (ItemsModel itemsModel : itemsModelList) {
                            if (itemsModel.getName().toLowerCase().contains(searchStr)) {
                                resultData.add(itemsModel);
                            }
                        }
                        filterResults.count = resultData.size();
                        filterResults.values = resultData;
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    itemsModelListFiltered = (List<ItemsModel>) results.values;
                    notifyDataSetChanged();
                }
            };
        }
    }
}
