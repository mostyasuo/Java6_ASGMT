package Client.User;

import java.text.Normalizer;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Dao.AccountDAO;
import Service.CookieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;
import model.Message;

@Controller
@RequestMapping("/client")
public class LoginController {

    @Autowired
    private CookieService cookieService;
    
    @Autowired
    private AccountDAO accountDAO;

    @GetMapping("/signin")
    public String signin(Account account, Model model) {
        String username = cookieService.getValue("username");
        account.setUsername(username);
        model.addAttribute("message", Message.message);
        model.addAttribute("typeMessage", Message.type);
        Message.message = "";
        model.addAttribute("account", account);
        return "index/login";
    }

    // @GetMapping("/signin/success")
    // public String success(Model model, HttpServletResponse response) {
    //     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    //     if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
    //         UserDetails userDetails = (UserDetails) authentication.getPrincipal();

    //         // Sử dụng thông tin userDetails
    //         String username = userDetails.getUsername();
    //         Account account = accountDAO.findById(username).get();
    //         cookieService.setCookie(response, "username", processString(account.getUsername()), 3600);
    //         System.out.println("Đăng nhập LOCAL thành công");
    //         return "redirect:/client/index";
    //     } else {
    //         return "redirect:/client/signin";
    //     }
    // }

    @GetMapping("/signin/error")
    public String error(RedirectAttributes redirectAttributes, HttpServletRequest request) {
        System.out.println("Đăng nhập thất bại");
        redirectAttributes.addFlashAttribute("loginMessage", "Sai tài khoản hoặc mật khẩu");
        return "redirect:/client/signin";
    }

    @GetMapping("/logout/success")
    public String logout(HttpServletResponse response) {
        cookieService.remove("username", response);
        System.out.println("Đăng xuất thành công");
        return "redirect:/client/signin";
    }

    // @GetMapping("/denied")
    // public String denied(Model model) {
    //     System.out.println("Bạn không có đủ quyền");
    //     return "redirect:/client/error";
    // }

    public static String processString(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String noDiacritics = pattern.matcher(normalized).replaceAll("");
        String result = noDiacritics.replaceAll("\\s+", "").toUpperCase();
        return result;
    }
}
