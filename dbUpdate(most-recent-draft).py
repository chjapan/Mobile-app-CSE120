import psycopg2
import json
import pickle


def connectDB():
    conn = psycopg2.connect(
            host="localhost",
            database="truckalert",
            user="postgres",
            password="postgres",
            port=5433
    )
    return conn

def insert(conn, cursor, report_id, report_txt, location_name, cardinal_direction, report_type, place_id, status, location_points, time):
    # try to execute the commands if it fails then rollback
    try:
        cursor.execute("insert into incidence (report_id, report_txt, location_name, cardinal_direction, report_type, place_id, status, location_points, time) values (%s,%s,%s,%s,%s,%s,%s,ST_GeomFromText(%s,4326),%s)",
             (report_id, report_txt, location_name, cardinal_direction, report_type, place_id, status, location_points, time)
        )

        #cursor.execute("select id, report_txt from incidence")
        conn.commit()
        print("succ insert")
        
        #rows = cursor.fetchall()

        #for row in rows:
        #    print(f"id {row[0]} report {row[1]}")

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


def searchCoord(conn, cursor, location_points):
    #try to search for point values
    try:
        #fileName = "fileNum.json"
        
        #cursor.execute("select location_points from incidence where location_points = ST_GeomFromText(%s,4326)", (location_points,))
        cursor.execute("select ST_X(location_points), ST_Y(location_points) from incidence")
        conn.commit()
        points = cursor.fetchall()

       # with open(fileName, 'w') as f_obj:
            #json.dump(points, f_obj)

        print((points[0]))
        #print("successful search")
        #with open('sample.json','w') as f:
        #    json.dump(points,f)
        return points

    except:
        conn.rollback()
        print("Information could not be found.")
