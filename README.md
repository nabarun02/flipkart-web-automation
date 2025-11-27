# 🛒 Flipkart Web Automation (Selenium + Java + TestNG)

A complete **Web UI Automation framework** built using **Java, Selenium WebDriver & TestNG**, designed to demonstrate e-commerce automation capability on **Flipkart**.
This suite automates product search, popularity-based filtering, discount-based product extraction, and top-product data retrieval using structured reusable wrapper functions.

---

## 📌 Features Implemented

| Test Case | Description                                             |
| --------- | ------------------------------------------------------- |
| **TC01**  | Fetch total number of products with rating **> 4**      |
| **TC02**  | Get **iPhone product titles** having discount **> 17%** |
| **TC03**  | Extract **top 5 Coffee Mugs** with *Title + Image URL*  |

---

## 🏗 Tech Stack

| Component       | Technology Used           |
| --------------- | ------------------------- |
| Language        | **Java 11+**              |
| Automation Tool | **Selenium WebDriver**    |
| Test Framework  | **TestNG**                |
| Build Tool      | **Gradle**                |
| Browser         | **Chrome / ChromeDriver** |

---

## 📂 Project Structure

```
flipkart_web_automation/
 ├── src
 │   ├── main
 │   │   └── java (empty for now – future framework expansion)
 │   └── test
 │       └── java/demo
 │           ├── TestCases.java        # Contains TestNG test scripts
 │           └── wrappers/Wrappers.java # Custom wrapper utility methods
 ├── resources/testng.xml               # Test Suite configuration
 ├── build.gradle                       # Gradle project config
 ├── assesment_result.json (generated)
 ├── run_assesment.sh/.bat (scripts)
 └── README.md
```

---

## 🚀 How To Run The Tests

### 1️⃣ Clone the project

```bash
git clone https://github.com/nabarun02/flipkart-web-automation.git
cd flipkart_web_automation
```

### 2️⃣ Run TestNG Suite using Gradle

```bash
./gradlew test
```

or on Windows:

```bash
gradlew.bat test
```

---

## 🧩 Wrapper Functionalities Available

* Navigate to Flipkart
* Enter text in search bar & auto submit
* Click element by XPath
* Count elements (generic-Xpath based)
* Extract discount-filtered product titles
* Fetch top-products with *Title + Image URL*

---

## 📌 Sample Test Execution Output

```
Test Suite for Buildout > Test Cases for Buildout > demo.TestCases.testCase01 STANDARD_OUT
    Washing Machines with rating more than 4: 23

Test Suite for Buildout > Test Cases for Buildout > demo.TestCases.testCase01 PASSED

Test Suite for Buildout > Test Cases for Buildout > demo.TestCases.testCase02 STANDARD_OUT
    There are no iPhones with discount more than 17%.

Test Suite for Buildout > Test Cases for Buildout > demo.TestCases.testCase02 PASSED

Test Suite for Buildout > Test Cases for Buildout > demo.TestCases.testCase03 STANDARD_OUT
    papita Moti Glass Glass Coffee Mug: https://rukminim2.flixcart.com/image/612/612/xif0q/mug/z/q/k/insulated-pearls-handle-glass-with-straw-350-1-uratech-original-imahh4jguuzbq2yz.jpeg?q=70
    MILTON Thermosteel , 300 ml, Black | Hot & Cold | Soup ...: https://rukminim2.flixcart.com/image/612/612/xif0q/mug/o/v/9/thermosteel-300-ml-black-hot-cold-soup-flask-tea-300-1-milton-original-imah3bhr7suzgvvh.jpeg?q=70
    MMTSWorld Reusable Glass Travel Sipper Tumbler with Str...: https://rukminim2.flixcart.com/image/612/612/xif0q/mug/b/h/u/reusable-glass-travel-sipper-tumbler-mug-with-straw-lid-juice-original-imahebwrkkmnznpj.jpeg?q=70
    Myoz Stainless Steel Vacuum Double Insulated Tumbler wi...: https://rukminim2.flixcart.com/image/612/612/xif0q/bottle/p/y/r/1200-stainless-steel-vacuum-double-insulated-tumbler-with-lid-original-imahgfn6yhbghadh.jpeg?q=70
    Kimaya Double Wall Vacuum Insulated Stainless Steel 304...: https://rukminim2.flixcart.com/image/612/612/xif0q/shopsy-mug/f/m/o/double-wall-vacuum-insulated-stainless-steel-304-tea-coffee-original-imahh9hgtnysevdx.jpeg?q=70

Test Suite for Buildout > Test Cases for Buildout > demo.TestCases.testCase03 PASSED

```

---

## 🔥 Future Enhancements

| Enhancement                                      | Status          |
| ------------------------------------------------ | --------------- |
| Automate login pop-up dismissal                  | ⏳ Pending       |
| Add Screenshot + Reporting engine                | ⏳ Pending       |
| Integrate Allure/Extent report                   | ⏳ Planned       |
| Parallel execution using TestNG or Selenium Grid | ⏳ Pending       |

---

## 📄 License

This project is created for learning & demonstration purpose.
Feel free to **fork and enhance** the framework!

---
