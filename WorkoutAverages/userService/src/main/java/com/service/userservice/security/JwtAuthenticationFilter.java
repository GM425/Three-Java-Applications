// package com.service.userservice.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import java.util.Optional;

// import com.service.userservice.entity.User;
// import com.service.userservice.jwt.JwtUtility;
// import com.service.userservice.security.SecurityConfig;
// import com.service.userservice.repository.UserRepository;
// // import com.service.userservice.service.UserService.JwtUtils;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.web.filter.OncePerRequestFilter;
// import com.service.userservice.service.UserService;
// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.io.IOException;

//    public class JwtAuthenticationFilter extends OncePerRequestFilter {

//        @Autowired
//        private UserDetails userDetails;

//        @Autowired
//        private JwtUtility jwtUtility;

//        @Autowired
//        private UserRepository userRepository;

//     //    public JwtAuthenticationFilter(UserService userService, JwtUtility jwtUtility, UserRepository userRepository){
//     //     this.userRepository = userRepository;
//     //     this.userService = userService;
//     //     this.jwtUtility = jwtUtility;
//     //    }

//        @Override
//        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

//            String authorizationHeader = request.getHeader("Authorization");

//            String token = null;
//            String username = null;

//            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//                if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
//                 token = authorizationHeader.substring(7);
//                 username = jwtUtility.extractUsername(token);
//                };
              
//            }

//         //    if (username != null && SecurityContextHolder.get.extractUsername(token));

//            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                Optional<User> userDetails = userRepository.findByUsername(username);
//                userDetails.orElseThrow(() -> new RuntimeException("Can't find an account with that username."));;

//                if (jwtUtility.validateToken(token)) {
//                 // if (jwtUtility.validateToken(token, userDetails.get())) {
//                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                 //    new UsernamePasswordAuthenticationToken(userService.findByUsername(username),null,userDetails.getAuthorities());
//                            new UsernamePasswordAuthenticationToken(userDetails,null,null);
//                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//                }
//            }

//            filterChain.doFilter(request, response);
//        }
//    }
   