<%-- 
    Document   : soinnsuBunkai
    Created on : 2017/02/09, 21:01:19
    Author     : Choir
    課題
    クエリストリングを利用して、以下の処理を実現してください。
    簡易素因数分解のロジックを作成します。
    クエリストリングから渡された数値を1ケタの素数で可能な限り分解し、
    元の値と素因数分解の結果を表示するようにしてください。
    2ケタ以上の素数が含まれた数値の場合は、
    「元の値　1ケタの素因数　その他」と表記して、その他　に含んでください。
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%

    int[] soinsu = new int[4];
    soinsu[0] = 2;
    soinsu[1] = 3;
    soinsu[2] = 5;
    soinsu[3] = 7;
    String getval = request.getParameter("val");
    
    ArrayList<Integer> arySosu = new ArrayList<Integer>();
    
    int val = 0;
    int srcVal = Integer.parseInt(getval);
    
    int cnt = 0;
    //素数で割って余りが出ないか確認
    int XX = 0;
    int ret;
    int i = 0;
   
    boolean roop = true;
    boolean keta = false;
    val = srcVal;
    while(roop)
    {
        if( (val % soinsu[i]) == 0)
        {
            arySosu.add(soinsu[i]);
            
            XX = val/soinsu[i];
            val = XX;
            switch(XX)
            {
                case 2:
                case 3:
                case 5:
                case 7:
                    arySosu.add(XX);
                    roop = false;
                    break;
                default:
                    break;
            }
        }
        else
        {
            //素数を大きくする
            i++;
            if(i > 3)
            {
                arySosu.add(val);   //2桁以上
                roop = false;
                keta = true;
            }
        }
    }
    int sosuCnt = arySosu.size();
    
    out.println("元の値:");
    out.println(srcVal);
    out.println("1ケタの素因数:");
    if(sosuCnt == 0) out.println("その他");
    
    for(int jj= 0;jj < sosuCnt ;jj++)
    {
        if(arySosu.get(jj) > 10)
        {
            out.println("その他");
            break;
        }
        else
        {
            out.println(arySosu.get(jj));
            
        }
    }
    //"元の数　1桁の素因数"　
    //"元の数　1桁の素因数　その他"
 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
