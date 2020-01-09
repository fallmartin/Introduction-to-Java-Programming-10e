
/**
 * Find the GPS locations for
 * Atlanta, Georgia;
 * Orlando, Florida;
 * Savannah, Georgia; and
 * Charlotte, North Carolina
 * from www.gps-data-team.com/map/ and compute the estimated area enclosed by
 * these four cities. (Hint: Use the formula in Programming Exercise 4.2 to
 * compute the distance between two cities. Divide the polygon into two triangles
 * and use the formula in Programming Exercise 2.19 to compute the area of a
 * triangle.)
 * 
 * Output:
 * Atlanta, Georgia (33.753746, -84.386330)
 * Orlando, Florida (28.538336, -81.379234)
 * Savannah, Georgia (32.076176, -81.088371)
 * Charlotte, North Carolina (35.227085, -80.843124)
 * 
 * Triangle Atlanta, Charlotte, Savannah:
 * Atlanta to Charlotte: 363.68 km
 * Charlotte to Savannah: 351.10 km
 * Savannah to Atlanta: 359.92 km
 * 
 * Triangle Atlanta, Savannah, Orlando:
 * Atlanta to Savannah: 359.92 km
 * Savannah to Orlando: 394.38 km
 * Orlando to Atlanta: 646.60 km
 * 
 * Estimated area: 118,235.76 sq km
 */
/**
 *
 * @author martinfall
 */
public class GeographyEstimateAreas {

    public static void main(String[] args) {
        // Declare constant variable to hold earth radius
        final double EARTH_RADIUS = 6371.01;

        // GPS location for Atlanta, Georgia
        // Latitude 33.753746
        // Longitude -84.386330
        double atlantaX = 33.753746;
        double atlantaY = -84.386330;
        System.out.printf("Atlanta, Georgia (%f, %f)\n", atlantaX, atlantaY);
        atlantaX = Math.toRadians(atlantaX);
        atlantaY = Math.toRadians(atlantaY);
        //System.out.printf("Atlanta, Georgia (%f, %f)\n", atlantaX, atlantaY);

        // GPS location for Orlando, Florida
        // Latitude 28.538336
        // Longitude -81.379234
        double orlandoX = 28.538336;
        double orlandoY = -81.379234;
        System.out.printf("Orlando, Florida (%f, %f)\n", orlandoX, orlandoY);
        orlandoX = Math.toRadians(orlandoX);
        orlandoY = Math.toRadians(orlandoY);
        //System.out.printf("Orlando, Florida (%f, %f)\n", orlandoX, orlandoY);

        // GPS location for Savannah, Georgia
        // Latitude 32.076176
        // Longitude -81.088371
        double savannahX = 32.076176;
        double savannahY = -81.088371;
        System.out.printf("Savannah, Georgia (%f, %f)\n", savannahX, savannahY);
        savannahX = Math.toRadians(savannahX);
        savannahY = Math.toRadians(savannahY);
        //System.out.printf("Savannah, Georgia (%f, %f)\n", savannahX, savannahY);

        // GPS location for Charlotte, North Carolina
        // Latitude 35.227085
        // Longitude -80.843124
        double charlotteX = 35.227085;
        double charlotteY = -80.843124;
        System.out.printf("Charlotte, North Carolina (%f, %f)\n", charlotteX, charlotteY);
        charlotteX = Math.toRadians(charlotteX);
        charlotteY = Math.toRadians(charlotteY);
        //System.out.printf("Charlotte, North Carolina (%f, %f)\n", charlotteX, charlotteY);

        // Triangle ACS -> Atlanta, Charlotte, Savannah
        System.out.println("\nTriangle Atlanta, Charlotte, Savannah:");

        // Side Atlanta to Charlotte
        double sideAC
                = EARTH_RADIUS
                * Math.acos(Math.sin(atlantaX) * Math.sin(charlotteX)
                        + Math.cos(atlantaX) * Math.cos(charlotteX) * Math.cos(atlantaY - charlotteY));

        System.out.printf("Atlanta to Charlotte: %.2f km\n", sideAC);

        // Side Charlotte to Savannah
        double sideCS
                = EARTH_RADIUS
                * Math.acos(Math.sin(charlotteX) * Math.sin(savannahX)
                        + Math.cos(charlotteX) * Math.cos(savannahX) * Math.cos(charlotteY - savannahY));

        System.out.printf("Charlotte to Savannah: %.2f km\n", sideCS);

        // Side Savannah to Atlanta
        double sideSA
                = EARTH_RADIUS
                * Math.acos(Math.sin(savannahX) * Math.sin(atlantaX)
                        + Math.cos(savannahX) * Math.cos(atlantaX) * Math.cos(savannahY - atlantaY));

        System.out.printf("Savannah to Atlanta: %.2f km\n", sideSA);

        // Triangle ASO -> Atlanta, Savannah, Orlando
        System.out.println("\nTriangle Atlanta, Savannah, Orlando:");
        
        // Side Atlanta to Savannah
        double sideAS
                = EARTH_RADIUS
                * Math.acos(Math.sin(atlantaX) * Math.sin(savannahX)
                        + Math.cos(atlantaX) * Math.cos(savannahX) * Math.cos(atlantaY - savannahY));

        System.out.printf("Atlanta to Savannah: %.2f km\n", sideAS);
        
        // Side Savannah to Orlando
        double sideSO
                = EARTH_RADIUS
                * Math.acos(Math.sin(savannahX) * Math.sin(orlandoX)
                        + Math.cos(savannahX) * Math.cos(orlandoX) * Math.cos(savannahY - orlandoY));

        System.out.printf("Savannah to Orlando: %.2f km\n", sideSO);
        
        // Side Orlando to Atlanta
        double sideOA
                = EARTH_RADIUS
                * Math.acos(Math.sin(orlandoX) * Math.sin(atlantaX)
                        + Math.cos(orlandoX) * Math.cos(atlantaX) * Math.cos(orlandoY - atlantaY));

        System.out.printf("Orlando to Atlanta: %.2f km\n", sideOA);
        
        // Calculate the area of each triangle using Heron's formula
        // b = sqrt (s * (s - s1) * (s - s2) * (s - s3))
        // Calculate s = (s1 + s2 + s3) / 2
        
        // Triangle ACS -> Atlanta, Charlotte, Savannah
        
        // Calculate s for triangle ACS
        double sForTriangleACS = (sideAC + sideCS + sideSA) / 2;
        
        // Calculate area for triangle ACS
        double areaACS = Math.sqrt(sForTriangleACS // s
                * (sForTriangleACS - sideAC) // (s - s1)
                * (sForTriangleACS - sideCS) // (s - s2)
                * (sForTriangleACS - sideSA)); // (s - s3)
        
        // Triangle ASO -> Atlanta, Savannah, Orlando
        
        // Calculate s for triangle ASO
        double sForTriangleASO = (sideAS + sideSO + sideOA) / 2;
        
        // Calculate area for triangle ASO
        double areaASO = Math.sqrt(sForTriangleASO // s
                * (sForTriangleASO - sideAS) // (s - s1)
                * (sForTriangleASO - sideSO) // (s - s2)
                * (sForTriangleASO - sideOA)); // (s - s3)
        
        // Calculate the area of the polygon
        double area = areaACS + areaASO;
        
        // Display the results
        System.out.printf("\nEstimated area: %,.2f sq km", area);
    }
}
