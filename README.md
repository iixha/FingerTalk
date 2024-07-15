# Finger Talk

**Finger Talk** is a fun and interactive game that teaches American Sign Language (ASL) letters and numbers. Designed to be entertaining and educational, this game features engaging graphics, sound effects, and challenges. It's suitable for all ages, allowing players to learn sign language in a fun way and earn points as they progress.

## Features

- Learn ASL letters and numbers through interactive gameplay.
- Engaging graphics and sound effects.
- Challenges to test your knowledge and earn points.
- Suitable for all age groups.

## Installation

### Prerequisites

- JDK 8 or later
- Hibernate
- JavaFX

### Setup

1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/finger-talk.git
    cd finger-talk
    ```
2. Configure Hibernate:

   - Create a file named `hibernate.cfg.xml` in the `src/main/resources` directory with the following content:

     ```xml
     <!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN" "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
     <hibernate-configuration>
         <session-factory>
             <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
             <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
             <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/your_database</property>
             <property name="hibernate.connection.username">your_username</property>
             <property name="hibernate.connection.password">your_password</property>
             <property name="hibernate.hbm2ddl.auto">update</property>
             <property name="hibernate.show_sql">true</property>
             <property name="hibernate.format_sql">true</property>
         </session-factory>
     </hibernate-configuration>
     ```

   - Replace `your_database`, `your_username`, and `your_password` with your actual MySQL database credentials.

3. Run the application:
    ```bash
    mvn javafx:run
    ```

## Usage

1. Launch the application using the steps above.
2. Navigate through the menu to select between learning ASL letters or numbers.
3. Follow the on-screen instructions to play the game and learn ASL.

## Contributing

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/new-feature`).
3. Commit your changes (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature/new-feature`).
5. Open a pull request.

## Contact

If you have any questions or feedback, feel free to reach out to us at hanashikhhaji@gmail.com

---

Happy learning with Finger Talk!
