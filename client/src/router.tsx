import { createBrowserRouter } from "react-router-dom";
import { RootLayout } from "./layouts/RootLayout";
import { ErrorPage } from "./pages/ErrorPage";
import { Mancala } from "./pages/Mancala";
import { useNavigate } from "react-router-dom";
import MatchHistory from "./pages/MatchHistory";


export const router = createBrowserRouter([
    {
        path: "/",
        element: <RootLayout />,
        errorElement: <ErrorPage />,
        children: [
            {
                index: true,
                element: <Mancala />
            },
            // Add the route for MatchHistory
            {
                path: "MatchHistory",
                element: <MatchHistory />
            }
        ]
    }
]);

