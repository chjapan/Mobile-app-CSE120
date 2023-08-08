import psycopg2

def connectDB():
    conn = psycopg2.connect(
            host="localhost",
            database="truckalert",
            user="postgres",
            password="postgres",
            port=5433
    )
    return conn

def insert(conn, cursor, id, report_txt, location, latitude, longitude):
    # try to execute the commands if it fails then rollback
    try:
        cursor.execute("insert into incidence (id, report_txt, location, latitude, longitude) values (%s,%s,%s,%s,%s)",
             (id , report_txt, location, latitude, longitude)
        )

        cursor.execute("select id, report_txt from incidence")
        conn.commit()

        rows = cursor.fetchall()

        for row in rows:
            print(f"id {row[0]} report {row[1]}")

    except:
        conn.rollback()
        print("insertion failed")


def delete(conn, cursor, id, report_txt, location, latitude, longitude):
    # try to delete if not report failure
    try:
        cursor.execute("delete from incidence where id = %s", (id,) )
        conn.commit()

    except:
        conn.rollback()
        print("deletion failed")