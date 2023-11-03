import { Outlet, useLocation } from "react-router-dom";
import logo from "../assets/logo.jpg";
import { NavButton } from "../components/NavButton";
import backgroundImg from '../assets/chessImage.jpg';

export const RootLayout = () => {
    const { pathname } = useLocation();

    return <div className="flex flex-col h-screen ">
        
        <main className="flex-1">
            <Outlet />
        </main>
    </div>
};
