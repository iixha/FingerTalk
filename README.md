
# Finger Talk

Finger Talk is a fun and interactive game designed to teach American Sign Language (ASL) letters and numbers. It is both entertaining and educational, featuring graphics, sound effects, and challenges. Suitable for all ages, this application helps users learn sign language in an engaging way and earn points as they progress.

## Features

- Learn ASL letters and numbers with interactive lessons
- Enjoy entertaining graphics and sound effects
- Take on challenges and earn points
- Suitable for all ages
- Supports audio and visual aids

## Requirements

- Java Development Kit (JDK) 8 or higher
- NetBeans IDE
- Hibernate ORM
- MySQL Database

## Setup and Installation

1. **Clone the repository:**
    ```bash
    git clone https://github.com/yourusername/finger-talk.git
    ```
   
2. **Open the project in NetBeans:**
    - Go to `File` > `Open Project`
    - Select the `finger-talk` folder

3. **Setup MySQL Database:**
    - Create a new MySQL database named `finger_talk_db`
    - Import the provided `finger_talk_db.sql` file to create the necessary tables

4. **Configure Hibernate:**
    - Open `hibernate.cfg.xml` and update the database connection settings:
    ```xml
    <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/finger_talk_db</property>
    <property name="hibernate.connection.username">yourusername</property>
    <property name="hibernate.connection.password">yourpassword</property>
    ```
    - Ensure you have the MySQL JDBC Driver in your project's library

5. **Build and run the project:**
    - Right-click on the project in the NetBeans Projects window
    - Select `Clean and Build`
    - Select `Run`

## Using the Application

1. **Navigate the Main Menu:**
    - Learn ASL letters and numbers
    - Take on challenges to test your knowledge
    - Explore the game settings and help sections

2. **Learning Mode:**
    - Select letters or numbers
    - Follow the instructions to learn the ASL signs
    - Listen to the audio cues and view the images

3. **Challenge Mode:**
    - Complete various challenges to test your ASL knowledge
    - Earn points and track your progress


## Demo

For a quick demonstration of the Finger Talk application, check out our video demo: [Watch the Demo](https://drive.google.com/file/d/1xI0GoSs0AGRqNG8ZGd_KUS1W06m7uMcp/view)

## Contact

If you have any questions or feedback, feel free to reach out to us at hanashikhhaji@gmail.com

---

Happy learning with Finger Talk!
