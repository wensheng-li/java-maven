/**
 * User Management
 * 
 * MIT License
 * 
 * Copyright (c) 2025 wenshengli
 * 
 * For the details, please refer to the LICENSE file.
 */

package com.myapp.usermanagement;

import java.util.List;
import java.util.Scanner;

import com.myapp.usermanagement.model.User;
import com.myapp.usermanagement.service.UserService;

public class App {
	public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== 用户管理系统 =====");
            System.out.println("1. 添加用户");
            System.out.println("2. 查询所有用户");
            System.out.println("3. 修改用户");
            System.out.println("4. 删除用户");
            System.out.println("0. 退出");
            System.out.print("选择操作：");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("输入姓名：");
                    String name = scanner.nextLine();
                    System.out.print("输入邮箱：");
                    String email = scanner.nextLine();
                    User user = userService.addUser(name, email);
                    System.out.println("添加成功：" + user);
                    break;
                case "2":
                    List<User> users = userService.getAllUsers();
                    System.out.println("用户列表：");
                    users.forEach(System.out::println);
                    break;
                case "3":
                    System.out.print("输入要修改的用户ID：");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    System.out.print("输入新姓名：");
                    String newName = scanner.nextLine();
                    System.out.print("输入新邮箱：");
                    String newEmail = scanner.nextLine();
                    if (userService.updateUser(updateId, newName, newEmail)) {
                        System.out.println("修改成功！");
                    } else {
                        System.out.println("用户ID不存在！");
                    }
                    break;
                case "4":
                    System.out.print("输入要删除的用户ID：");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    if (userService.deleteUser(deleteId)) {
                        System.out.println("删除成功！");
                    } else {
                        System.out.println("用户ID不存在！");
                    }
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("无效操作！");
            }
        }

        scanner.close();
        System.out.println("系统退出！");
    }
}
