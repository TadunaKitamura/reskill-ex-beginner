package com.example.exSpring1.controller;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.example.exSpring1.model.Item;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/shopping")
public class ShoppingCartController {
    

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ServletContext applicatinServletContext;

    @Autowired
    private HttpSession session;

    @GetMapping("/")
  public String index(Model model) {
    // 商品一覧を取得
    List<Item> itemList = (List<Item>) applicatinServletContext.getAttribute("itemList");
    if (itemList == null) {
      itemList = createItems();
      applicatinServletContext.setAttribute("itemList", itemList);
    }

    // カートを取得
    List<Item> cartList = (List<Item>) session.getAttribute("cartList");
    if (cartList == null) {
      cartList = new LinkedList<>();
      session.setAttribute("cartList", cartList);
    }

    // 合計金額を計算
    int totalPrice = 0;
    for (Item item : cartList) {
      totalPrice += item.getPrice();
    }

    // 各属性をModelに追加
    model.addAttribute("itemList", itemList);
    model.addAttribute("cartList", cartList);
    model.addAttribute("totalPrice", totalPrice);

    // 商品一覧とショッピングカート一覧画面を表示
    return "item-and-cart";
  }

  @PostMapping("/inCart")
public String inCart(String name) {
  // applicationContextからWebApplicationContextを取得
  WebApplicationContext webApplicationContext = (WebApplicationContext) applicationContext;

  // WebApplicationContextからServletContextを取得
  ServletContext servletContext = webApplicationContext.getServletContext();

  // ServletContextからitemListを取得
  List<Item> itemList = (List<Item>) servletContext.getAttribute("itemList");

  // 送られてきた商品名に基づいて商品を取得
  Item item = findItemByName(itemList, name);

  // 取得した商品をカートに追加
  List<Item> cartList = (List<Item>) session.getAttribute("cartList");
  cartList.add(item);

  // 商品一覧とショッピングカート一覧画面にリダイレクト
  return "redirect:/shopping/";
}

  @PostMapping("/delete")
  public String delete(String name) {
    // カートを取得
    List<Item> cartList = (List<Item>) session.getAttribute("cartList");

    // 送られてきた商品名に基づいて商品を削除
    cartList.removeIf(item -> item.getName().equals(name));

    // 商品一覧とショッピングカート一覧画面にリダイレクト
    return "redirect:/shopping/";
  }

  // 商品名に基づいて商品リストから商品を取得するメソッド
  private Item findItemByName(List<Item> itemList, String name) {
    for (Item item : itemList) {
      if (item.getName().equals(name)) {
        return item;
      }
    }
    return null;
  }

  // 商品一覧を作成するメソッド
  private List<Item> createItems() {
    List<Item> items = new LinkedList<>();
    items.add(new Item("手帳ノート", 1000));
    items.add(new Item("文房具セット", 1500));
    items.add(new Item("ファイル", 2000));
    return items;
  }
}
