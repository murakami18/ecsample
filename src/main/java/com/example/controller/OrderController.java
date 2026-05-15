package com.example.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.CartItem;
import com.example.entity.User;
import com.example.service.CartService;
import com.example.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	private final CartService cartService;
	private final OrderService orderService;

	public OrderController(CartService cartService, OrderService orderService) {
		this.cartService = cartService;
		this.orderService = orderService;
	}

	/** 購入を確定する */
	@PostMapping("/confirm")
	public String confirm(HttpSession session, Model model) {
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			return "redirect:/login";
		}

		List<CartItem> cart = cartService.getCart(session);
		if (cart.isEmpty()) {
			return "redirect:/cart";
		}

		int orderId = orderService.placeOrder(loginUser.getId(), cart);
		cartService.clearCart(session);

		model.addAttribute("orderId", orderId);
		return "order/complete";
	}
}